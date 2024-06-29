const thumbnail = document.getElementById('thumbnail');
const fileImage = document.getElementById('fileImage');


fileImage.onchange = function() {
  let input = fileImage.files[0];
  if (input) {
	  var reader = new FileReader();
      reader.onload = function (e) {
			thumbnail.setAttribute('src', e.target.result);
      }
      reader.readAsDataURL(input);
  }
};