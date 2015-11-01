(function (window, carSearch) {
	'use strict';

	var document = window.document;

	carSearch.SearchController = function (element) {
		this.element = element;
	};

	carSearch.SearchController.prototype = {
		initialize: function () {
			this._createSearchPage();
		},

		_createSearchPage: function (){
			var searchPageElement = document
				.createElement('div');

			var searchPage = new carSearch.SearchPage(searchPageElement);
			var searchPageOptions = new carSearch.SearchPageOptions();

			//---
			searchPageOptions.setOnSearchBoxChange(function(searchBox, eventArgs){
				var value = eventArgs.getValue();

				var searchContext = new carSearch.SearchContext(
					carSearch.AppConfig.carSearchResource);

				//---
				searchContext.searchCars({
					query: value,

					onSuccess: function (data){

					},

					onFailure: function (){

					}
				});
			});

			searchPage.setOptions(searchPageOptions);
		}
	};
	
})(window, window.carSearch);