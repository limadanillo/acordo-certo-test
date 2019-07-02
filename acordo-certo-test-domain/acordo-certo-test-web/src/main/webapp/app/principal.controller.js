angular.module("acordoCertoApp").controller("PrincipalController", PrincipalController);

PrincipalController.inject = [ '$scope', 'Empregado', 'Departamento' ];

function PrincipalController($scope, Empregado, Departamento) {
	$scope.departamentos = Departamento.query();
	$scope.empregados = Empregado.query();

	$scope.empregado = {};
	$scope.departamento = {};

	$scope.saveEmpregado = function() {
		if ($scope.empregado.id !== undefined) {
			Empregado.update($scope.empregado, function() {
				$scope.empregados = Empregado.query();
				$scope.empregado = {};
			});
		} else {
			Empregado.save($scope.empregado, function() {
				$scope.empregados = Empregado.query();
				$scope.empregado = {};
			});
		}
	}

	$scope.updateEmpregadoInit = function(empregado) {
		$scope.empregado = empregado;
	}

	$scope.deleteEmpregado = function(empregado) {
		empregado.$delete({id: empregado.id}, function() {
			$scope.empregados = Empregado.query();
		});
	}

	$scope.saveDepartamento = function() {
		if ($scope.departamento.id !== undefined) {
			Departamento.update($scope.departamento, function() {
				$scope.departamentos = Departamento.query();
				$scope.departamento = {};
			});
		} else {
			Departamento.save($scope.departamento, function() {
				$scope.departamentos = Departamento.query();
				$scope.departamento = {};
			});
		}
	}

	$scope.deleteDepartamento = function(departamento) {
		departamento.$delete({id: departamento.id}, function() {
			$scope.departamentos = Departamento.query();
		});
	}

	$scope.updateDepartamentoInit = function(departamento) {
		$scope.departamento = departamento;
	}
}