const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./halRestClient');

/**
 * Same but using the obsolete class component paradigm
 * instead of functional components
 */
class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {commandes: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/data-rest/commandes'}).done(response => {
			this.setState({commandes: response.entity._embedded.commandes});
		});
	}

	render() {
		return (
			<CommandeList commandes={this.state.commandes}/>
		)
	}
}

class CommandeList extends React.Component{
	render() {
		const commandes = this.props.commandes.map(commande =>
			<Commande key={commande._links.self.href} commande={commande}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>ID</th>
						<th>Id produit</th>
						<th> Nom </th>
						<th>Quantité</th>
						<th>Statut</th>
					</tr>
					{commandes}
				</tbody>
			</table>
		)
	}
}

class Commande extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.commande.id}</td>
				<td>{this.props.commande.produitId}</td>
				<td> {this.props.commande.nom}</td>
				<td>{this.props.commande.quantite}</td>
				<td>{this.props.commande.status}</td>
			</tr>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)