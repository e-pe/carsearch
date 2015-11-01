(function (carSearch) {
	'use strict';

	carSearch.SearchBox = function (element){
		this.element = element;

		this.inputElement = null;
		this.onValueChange = null;

		this.interactionProvider = null;
	};

	carSearch.SearchBox.prototype = {
		getInputElement: function (){
			if(!this.inputElement){
				this.inputElement = this._initializeInputElement();
			}

			return this.inputElement;
		},

		getInteractionProvider: function(){
			if(!this.interactionProvider){
				this.interactionProvider = new carSearch.SearchBoxInteractionProvider(this);
			}

			return this.interactionProvider;
		},

		initialize: function () {
			this.getInputElement();

			this.getInteractionProvider().registerChangeSender();
		},

		addValueChange: function (onValueChange){
			this.onValueChange = onValueChange;
		},

		_raiseChange: function (value){
			if(this.onValueChange) {
				this.onValueChange.call(this, new carSearch.SearchBoxChangeEventArgs(value));
			}
		},

		_initializeInputElement: function(){
			return null;
		}
	};
		
})(window.carSearch);