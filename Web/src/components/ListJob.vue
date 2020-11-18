<template>
<div id="app">
    <md-table md-card class="container-fluid md-elevation-12">
        <md-table-row align="left">
            <md-table-head>Company</md-table-head>
            <md-table-head>Position</md-table-head>
            <md-table-head>Description</md-table-head>
            <md-table-head>Salary</md-table-head>
            <md-table-head>
                <b-button variant="outline-success" v-b-modal.modal-xl="'add'">Add Job</b-button>
            </md-table-head>
        </md-table-row>

        <md-table-row v-for="job in orderedjobs" v-bind:key="job.id" align="left">
            <md-table-cell>{{ job.company }}</md-table-cell>
            <md-table-cell>{{ job.title }}</md-table-cell>
            <md-table-cell>{{ job.description }}</md-table-cell>
            <md-table-cell>{{ job.salary }}</md-table-cell>
            <md-table-cell>
                <!-- <b-button variant="outline-info" @click="sendInfo(job)" v-b-modal.modal-xl="'job'">List Applicants</b-button> -->
                <!-- &nbsp;
                <b-button variant="outline-primary" @click="sendInfo(job)" v-b-modal.modal-xl="'edit'">Edit</b-button> -->
                &nbsp;
                <b-button variant="outline-danger" @click="deletejob(job)">
                    Remove
                </b-button>
            </md-table-cell>
        </md-table-row>
    </md-table>

    <b-modal size="xl" id="add">
        <AddJob></AddJob>
    </b-modal>

    <b-modal size="xl" id="job" :title="selectedjob.company + ' - ' + selectedjob.title">
        <div v-for="apply in job_apply" v-bind:key="apply.email">
            <div v-for="user in users" v-bind:key="user.email">
                <div v-if="apply.job == selectedjob.id">
                    <b-card v-if="apply.email == user.email" :title="user.name">
                        <b-button v-b-toggle.collapse-1 variant="outline-info">View user</b-button>
                        <b-collapse id="collapse-1" class="mt-2">
                            <b-card>
                                <Resume></Resume>
                            </b-card>
                        </b-collapse>
                    </b-card>
                </div>
                <br />
            </div>
        </div>
    </b-modal>

    <b-modal size="xl" id="edit" :title="selectedjob.company + ' - ' + selectedjob.title">
        <label for="input-live">Job ID</label>
        <b-form-input id="input-live" size="20" v-model="newJobid" aria-describedby="input-live-help input-live-feedback" trim :value="selectedjob.id"></b-form-input>

        <label for="input-live">Title</label>
        <b-form-input id="input-live" size="20" v-model="newTitle" aria-describedby="input-live-help input-live-feedback" :value="selectedjob.title"></b-form-input>

        <label for="input-live">Company</label>
        <b-form-input id="input-live" size="20" v-model="newCompany" aria-describedby="input-live-help input-live-feedback" :value="selectedjob.company"></b-form-input>

        <label for="input-live">Description</label>
        <b-form-textarea id="textarea-default" size="20" v-model="newDescription" aria-describedby="input-live-help input-live-feedback" :value="selectedjob.description"></b-form-textarea>

        <label for="input-live">Salary</label>
        <b-form-input id="input-live" size="20" type="number" v-model="newSalary" aria-describedby="input-live-help input-live-feedback" trim :value="selectedjob.salary"></b-form-input>

        <br />
        <b-button variant="outline-success">
            Edit job
        </b-button>
    </b-modal>

    <br />
</div>
</template>

<script>
import {
    db
} from "../firebase";
import _ from "lodash";
import Resume from "./Resume";
import AddJob from "./AddJob"

export default {
    name: "TableCard",
    components: {
        AddJob,
        Resume,
    },
    computed: {
        orderedjobs: function () {
            return _.orderBy(this.jobs, ["created"], ["desc"]);
        },
    },
    data() {
        return {
            jobs: [],
            job_apply: [],
            users: [],
            selectedjob: "",
            newJobid: "",
            newTitle: "",
            newCompany: "",
            newDescription: "",
            newSalary: "",
        };
    },
    firestore() {
        return {
            jobs: db.collection("jobs"),
            job_apply: db.collection("job_apply"),
            users: db.collection("users"),
        };
    },
    methods: {
        deletejob: function (job) {
            this.$firestore.jobs.doc(job[".key"]).delete();
        },
        // editjob: function(job) {

        // },
        sendInfo(job) {
            this.selectedjob = job;
        },
    },
};
</script>

<style>
#app {
    font-family: "Avenir", Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
}

.card-add {
    width: 500px;
    position: relative;
    margin-left: auto;
    margin-right: auto;
}

.card-job {
    width: 800px;
    position: relative;
    margin-left: 50%;
    margin-right: 50%;
}
</style>
