(function (carSearch) {
	'use strict';

	carSearch.SearchContext = function (config) {
		this.config = config;
	};

	carSearch.SearchContext.prototype = {
		searchCars: function (options){
			var httpResourceInvoker = new carSearch.HttpResourceInvoker();

			httpResourceInvoker.httpGet({
				url: this.config.resourceUrl,

				params: {
					query: options.query
				},

				onSuccess: function (data){
					if(options.onSuccess){
						options.onSuccess(data);
					}
				},

				onFailure: function (){
					if(options.onFailure){
						options.onFailure();
					}
				}
			});
		}	
	};
	
})(window.carSearch);