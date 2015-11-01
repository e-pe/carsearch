(function (carSearch) {
	'use strict';

	carSearch.AppController = function (element) {
		this.element = element;
	};

	carSearch.AppController.prototype = {
		initialize: function () {
			var searchController = new carSearch.SearchController(this.element);

			//---
			searchController.initialize();
		}
	};
	
})(window.carSearch);