var formMode = '';

function toggleForm(mode) {
    var form = document.getElementById("productForm");
    var submitButton = document.getElementById("submitButton");

    if (mode === 'add') {
        formMode = 'add';
        submitButton.innerText = 'Add Product';
    } else if (mode === 'edit') {
        formMode = 'edit';
        submitButton.innerText = 'Edit Product';
    } else {
        formMode = '';
        submitButton.innerText = 'Submit';
    }

    if (form.style.display === "none") {
        form.style.display = "block";
    } else {
        form.style.display = "none";
    }
}