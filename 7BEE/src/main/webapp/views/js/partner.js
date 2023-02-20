function displaySelectedImages(input) {
	var files = input.files;
	var selectedImages = document.querySelector("#selectedImages .carousel-inner");
	selectedImages.innerHTML = "";

	function addImageToCarousel(index) {
		return function(e) {
			selectedImages.innerHTML += `
                        <div style="height: 17em;" class="carousel-item ${index == 0 ? 'active' : ''}">
                            <img src="${e.target.result}" class="d-block w-50 h-100 mx-auto img-thumbnail img-fluid" alt="${files[index].name}">
                        </div>`;
		}
	}

	for (var i = 0; i < files.length; i++) {
		var reader = new FileReader();
		reader.onload = addImageToCarousel(i);
		reader.readAsDataURL(files[i]);
	}
}