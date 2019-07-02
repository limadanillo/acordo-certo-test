angular.module('acordoCertoApp').factory('Empregado', Empregado);

Empregado.$inject = [ '$resource' ];

function Empregado($resource) {
	var resourceUrl = 'api/empregado/:id';

	return $resource(resourceUrl, {}, {
		'update' : {
			method : 'PUT'
		}
	});
}