/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

var app = new Vue({
    el: "#app",
    data() {
    return {
      rows: [
        ],
        editForm: {
            id: "",
            name: "",
            year: "",
            rank: "",
        },
    };
  },
    mounted: function (key) {
        this.fetchJson();
    },
    methods: {
        fetchJson: async function () {
            URI = "http://localhost:8080/api/movies";
            fetch(URI)
                    .then((res) => res.json())
                    .then((data) => (this.rows = data));
        },
        //      sortTableBy: function () {
        //        console.log("called");
        //        let dir = this.isAscendingOrder ? 1 : -1;
        //        const sortBy = this.sortBy;
        //
        //        return this.rows.sort((a, b) =>
        //          a[sortBy] > b[sortBy] ? 1 * dir : -1 * dir
        //        );
        //      },
        saveMovie: function () {
            if (this.editForm.id === "" || this.editForm.name === "" || this.editForm.year === "" || this.editForm.rank === "") {
                return;
            } else {
                URI = `http://localhost:8080/api/movies/${this.editForm.id}`;
                try {
                    fetch(URI, {method: 'PUT',
                        headers: {
                            'Content-Type': 'application/json'
                        }, body:
                                JSON.stringify(this.editForm)

                    }).then(response => {
                        if (response.ok) {
                            console.log('Movie Edited successfully')
                            // Reset the form fields
                            this.editForm.id = "";
                            this.editForm.name = "";
                            this.editForm.year = "";
                            this.editForm.rank = "";
                            this.fetchJson();
                        } else {
                            console.log('Failed to Edit movie');
                        }
                    });
                } catch (error) {
                    throw error;
                }
            }
            this.fetchJson();
            return "Save Movie";
            console.log("called Save");
        },
        editMovie: function (row) {
            this.editForm.id = row.id;
            this.editForm.name = row.name;
            this.editForm.year = row.year;
            this.editForm.rank = row.rank.toFixed(1);
            console.log("called Edit");
            return "Edit Movie";
        },
        deleteMovie: function (row) {

            URI = `http://localhost:8080/api/movies/${row.id}`;
            console.log(URI)
            try {
                fetch(URI, {method: "DELETE", headers: {
                        'Content-Type': 'application/json'
                    }}).then(()=>{
                    this.fetchJson();
                    })
            } catch (e) {
                console.log("FAILED")
                throw e;
            }
            
            console.log("called Delete");
            return "Delete Movie";
        },
    },
});
