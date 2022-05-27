/**
 * 
 */

function isExtension(targetFilename){
	var dotIndex=targetFilename.lastIndexOf(".");
	var targetExtension=targetFilename.substring(dotIndex+1);
	var ext=targetExtension.toLowerCase();
	if(ext =="jpg" || ext == "png" || ext
			== "gif"){
		return true;
	}
	else{
		return false;
	}
}

function getFilename(originalfilename){
	var slashIndex=originalfilename.lastIndexOf("_");
	var targetFilename = originalfilename.substring(slashIndex+1);
	return targetFilename;
}

