
var propertyFilters = angular.module("TruncateFilter", []);
/**
 * Truncate filter. Truncate till first found space.
 */
propertyFilters.filter('truncate', function(){
	return function(text,limit,showMore){
		if(!angular.isUndefined(text)){
			//only if text is longer than
			if(showMore == "Show more" && text.length > limit){
				var regex = /\s/;
				for(var i=0;i<limit;i++){
					if(regex.exec(text[limit-i])){
						limit = limit - i;
						break;
					}
				}
				var result = text.slice(0, limit);
				result += "...";
				return result;
			}
			return text;
		}
	};
});