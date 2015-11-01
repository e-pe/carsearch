(function (carSearch) {
    'use strict';

    carSearch.SearchPageOptions = function (){
        this.onSearchBoxChange = null;
    };

    carSearch.SearchPageOptions.prototype = {
        getOnSearchBoxChange: function(){
           return this.onSearchBoxChange;
        },

        setOnSearchBoxChange: function(handler){
            this.onSearchBoxChange = handler;
        }
    };

})(window.carSearch);
