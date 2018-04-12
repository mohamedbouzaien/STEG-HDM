var Script = function () {

    $.validator.setDefaults({
        submitHandler: function() { alert("Utilisateur ajouté!"); }
    });

    $().ready(function() {
        // validate the comment form when it is submitted
        $("#commentForm").validate();

        // validate signup form on keyup and submit
        $("#signupForm").validate({
            rules: {
                prenom: "required",
                nom: "required",
                matricule: {
                    required: true,
                    minlength: 5
                },
                motdepasse: {
                    required: true,
                    minlength: 5
                },
                confirmer_pass: {
                    required: true,
                    minlength: 5,
                    equalTo: "#motdepasse"
                },
                role : "required"
            },
            messages: {
                prenom: "Veuillez ajouter un prénom!",
                nom: "Veuillez ajouter un nom!",
                matricule: {
                    required: "Veuillez ajouter une matricule",
                    minlength: "Votre matricule doit consister d'au moin 5 caractéres de long"
                },
                motdepasse: {
                    required: "Veuillez ajouter un mot de passe",
                    minlength: "Votre matricule doit consister d'au moin 5 caractéres de long"
                },
                confirmer_pass: {
                    required: "Veuillez ajouter un mot de passe",
                    minlength: "Your password must be at least 5 characters de long",
                    equalTo: "Veuillez entrer un mot de passe identique a celui d'au dessus"
                },
                role: "veuillez choisir un rôle"
            }
        });
    });


}();