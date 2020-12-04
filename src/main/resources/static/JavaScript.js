angular.module("Model", []).controller("Controller", ["$scope", "$http", "$q", function ($scope, $http, $q) {

	$scope.getProdutoIdOrderByDataMovimentos = [];
	$scope.getProdutoIdOrderByDataMovimento = {};
	$scope.getByOrderByDataTombamentos = [];
	$scope.elemento = {};


	$scope.limpar = function () {
		window.location.href = window.location.href;
	};

	$scope.validarCamporAntesDeSalvarItem = function () {
		if ((this.elemento.nomeProduto == undefined || this.elemento.nomeProduto == '') || (this.elemento.registroTombamento == undefined || this.elemento.registroTombamento == '') || (this.elemento.lote == undefined || this.elemento.lote == '')) {
			return alert("Preencha todos os campos");
		}
		$scope.salvarItem();
	}

	$scope.validarPesquisa = function () {
		if (this.elemento.nomeProduto !== undefined) {

			sessionStorage.setItem("pesquisa", "/getdByNomeProduto?nomeProduto=" + this.elemento.nomeProduto);
			alert("A pesquisa será realizada por nomeProduto");
			return $scope.pesquisarItem();

		}
		if (this.elemento.lote !== undefined) {
			sessionStorage.setItem("pesquisa", "/getdByLote?lote=" + this.elemento.lote);
			alert("A pesquisa será realizada por lote");

			return $scope.pesquisarItem();

		}
		if (this.elemento.registroTombamento !== undefined) {
			sessionStorage.setItem("pesquisa", "/getdByRegistroTombamento?registroTombamento=" + this.elemento.registroTombamento);
			alert("A pesquisa será realizada por registroTombamento");

			return $scope.pesquisarItem();

		}

	}

	$scope.pesquisarItem = function () {
		$.ajax({
			url: "/produto/" + sessionStorage.pesquisa,
			type: "GET",
			crossDomain: true,
			contentType: "application/json",
			async: false,
			success: function (response) {
				$scope.getByOrderByDataTombamento = response;
			},
			error: function (xhr, status, error) {
				alert("Entre Em Contato Com O Adminstrador Do Sistema.");
			}
		});
	}

	$scope.validarCampos = function () {
		if ((this.getProdutoIdOrderByDataMovimento.destino == undefined) || (this.getProdutoIdOrderByDataMovimento.observacao == undefined) || (this.getProdutoIdOrderByDataMovimento.emUso == undefined)) {
			return alert("Preencha todos os campos");
		}
		$scope.saveHistorico();
	}

	$scope.saveHistorico = function () {
		var objeto = {

			destino: this.getProdutoIdOrderByDataMovimento.destino,
			observacao: this.getProdutoIdOrderByDataMovimento.observacao,
			emUso: this.getProdutoIdOrderByDataMovimento.emUso,
			dataMovimento: new Date().toISOString(),
			produto: {
				id: sessionStorage.id
			}
		}
		console.log(JSON.stringify(objeto));

		$.ajax({
			url: "/historico/save",
			type: "POST",
			crossDomain: true,
			contentType: "application/json",
			data: JSON.stringify(objeto),
			async: false,
			success: function (response) {
				alert(JSON.stringify(response));
				window.location.href = window.location.href;

			},
			error: function (xhr, status, error) {
				alert("Entre Em Contato Com O Adminstrador Do Sistema.");
			}
		});
	};

	$scope.salvarItem = function () {
		var objeto = {
			nomeProduto: this.elemento.nomeProduto,
			dataTombamento: new Date().toISOString(),
			lote: this.elemento.lote,
			registroTombamento: this.elemento.registroTombamento,
			emUso: true,
		}
		console.log(JSON.stringify(objeto));

		$.ajax({
			url: "/produto/save",
			type: "POST",
			crossDomain: true,
			contentType: "application/json",
			data: JSON.stringify(objeto),
			async: false,
			success: function (response) {
				alert(JSON.stringify(response));
				window.location.href = window.location.href;
			},
			error: function (xhr, status, error) {
				alert("Entre Em Contato Com O Adminstrador Do Sistema.");
			}
		});
	};

	$scope.getProdutoIdOrderByDataMovimento = function () {
		$scope.$parent.$$childHead.getProdutoIdOrderByDataMovimento.nomeProduto = this.date.nomeProduto;
		$scope.$parent.$$childHead.getProdutoIdOrderByDataMovimento.lote = this.date.lote;
		$scope.$parent.$$childHead.getProdutoIdOrderByDataMovimento.registroTombamento = this.date.registroTombamento;
		sessionStorage.setItem("id", this.date.id);

		$.ajax({
			url: "/historico/getProdutoIdOrderByDataMovimento?id=" + this.date.id,
			type: "GET",
			crossDomain: true,
			contentType: "application/json",
			async: false,
			success: function (response) {
				$scope.getProdutoIdOrderByDataMovimentos = response;
			},
			error: function (xhr, status, error) {
				alert("Entre Em Contato Com O Adminstrador Do Sistema.");
				window.location.href = window.location.href;

			}
		});
	}

	$scope.getByOrderByDataTombamento = function () {
		$.ajax({
			url: "/produto/getByOrderByDataTombamento",
			type: "GET",
			crossDomain: true,
			contentType: "application/json",
			async: false,
			success: function (response) {
				$scope.getByOrderByDataTombamento = response;
			},
			error: function (xhr, status, error) {
			}
		});
	}




}]);