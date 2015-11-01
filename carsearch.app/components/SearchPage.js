(function (window, carSearch) {
    'use strict';

    var document = window.document

    carSearch.SearchPage = function (element){
        this.element = element;

        this.options = null;
    };

    carSearch.SearchPage.prototype = {
        getOptions: function (){
            return this.options;
        },

        setOptions: function (value){
            this.options = value;
        },

        initialize: function () {
            this._createSearchBox();
            this._createSearchGrid();
        },

        _createSearchBox: function (){
            var self = this;

            var searchBoxElement = document
                .createElement('div');

            var searchBox = carSearch.SearchBox(searchBoxElement);

            searchBox.addValueChange(function (sender, eventArgs) {
                if(self.options.onSearchBoxChange){
                    self.options.onSearchBoxChange.apply(self, [sender, eventArgs]);
                }
            });
        },

        _createSearchGrid: function (){
            var searchGrid = carSearch.SearchGrid();
        }
    };

})(window, window.carSearch);
