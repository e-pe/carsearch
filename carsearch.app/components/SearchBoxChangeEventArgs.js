(function (carSearch) {
    'use strict';

    carSearch.SearchBoxChangeEventArgs = function (value){
        this.value = value;
    };

    carSearch.SearchBoxChangeEventArgs.prototype = {
        getValue: function () {
            return this.value;
        }
    };

})(window.carSearch);
