var SearchBox = React.createClass({
    getInitialState: function () {
        return {data: []};
    },

    updateData: function (data) {
        this.setState({
            data: data
        });
    },

    render: function () {
        return (
            <div className="SearchBox container">
                <h1>Search Box</h1>
                <SearchLine url={this.props.url} listener={this.updateData}/>
                <ResultList data={this.state.data}/>
            </div>
        );
    }
});

var Result = React.createClass({
    render: function () {
        return (
            <tr>
                <td>
                    {this.props.employee.Nachname}
                </td>
                <td>
                    {this.props.employee.Abteilung}
                </td>
                <td>
                    {this.props.employee.Raum}
                </td>
                <td>
                    {this.props.employee.Stelle}
                </td>
                <td>
                    {this.props.employee.Telefon}
                </td>
            </tr>
        );
    }
});

var ResultList = React.createClass({

    render: function () {

        var ResultNode = this.props.data.map(function (result, i) {
            return (
                <Result employee={result}  key={i}/>
            );
        });

        return (
            <div className="result-list row">
                <table className="table table-hover">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Department</th>
                            <th>Room</th>
                            <th>Role</th>
                            <th>Tel.</th>
                        </tr>
                    </thead>
                    <tbody>
                        {ResultNode}
                    </tbody>
                </table>
            </div>
        );
    }
});

var SearchLine = React.createClass({
    findEmployeesByTerm: function (term) {
        $.ajax({
            url: this.props.url + "?term=" + term,
            dataType: 'json',
            cache: false,
            success: function (data) {
                this.props.listener(data);
            }.bind(this),
            error: function (xhr, status, error) {
                console.error(this.props.url, status, error.toString());
            }.bind(this)
        });
    },

    handleChange: function (event) {
        this.findEmployeesByTerm(event.target.value);
    },

    render: function () {
        return (
            <div className="row">
                <input type="text" className="search-input form-control" placeholder="Type a word..." onChange={this.handleChange}></input>
            </div>
        );
    }
});

var data = [
    {
        id: "AVCOlFSfI3oP7QIM-DOu",
        Nachname: "Abramidis, Alexander",
        Abteilung: "Software Factories",
        Raum: "",
        Stelle: "Software Developer",
        Telefon: ""
    },
    {
        id: "AVCOlFSfI3oP7QIM-DOv",
        Nachname: "Abu Marya, Yamen",
        Abteilung: "Projects",
        Raum: "5.25",
        Stelle: "Professional Frontend Developer",
        Telefon: "+4930 24627 312"
    }
];

ReactDOM.render(
    <SearchBox url="http://localhost:8081/api/employees/"/>,
    document.getElementById("search-box")
);