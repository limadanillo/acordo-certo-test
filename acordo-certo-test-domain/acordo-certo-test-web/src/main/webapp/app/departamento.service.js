(function() {
	'use strict';
	angular.module('acordoCertoApp').factory('Departamento', Departamento);

	Departamento.$inject = [ '$resource' ];

	function Departamento($resource) {
		var resourceUrl = 'api/departamento/:id';

		return $resource(resourceUrl, {}, {
			'update' : {
				method : 'PUT'
			}
		});
	}
})();
