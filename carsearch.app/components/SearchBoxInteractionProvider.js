(function (carSearch) {
    'use strict';

    carSearch.SearchBoxInteractionProvider = function (searchBox){
        this.searchBox = searchBox;
    };

    carSearch.SearchBoxInteractionProvider.prototype = {
        registerChangeSender: function (){
            var self = this;

            document.addEventListener('keyup', function(event){
                self._onChangeKeyUp.apply(self, [self.searchBox, event]);
            });
        },

        _onChangeKeyUp: function(searchBox, event){
            var inputElement = searchBox.getInputElement();

            searchBox._raiseChange(inputElement.value);
        }
    };

})(window.carSearch);
