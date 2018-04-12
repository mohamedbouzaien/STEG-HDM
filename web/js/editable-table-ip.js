/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var EditableTable = function () {

    return {

        //main function to initiate the module
        init: function () {
            function restoreRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);

                for (var i = 0, iLen = jqTds.length; i < iLen; i++) {
                    oTable.fnUpdate(aData[i], nRow, i, false);
                }

                oTable.fnDraw();
            }

            function editRow(oTable, nRow) {
                var aData = oTable.fnGetData(nRow);
                var jqTds = $('>td', nRow);
                //jqTds[0].innerHTML = '<input type="text" class="form-control small" value="' + aData[0] + '">';
                jqTds[2].innerHTML = '<input type="text" class="form-control small" value="' + aData[2] + '">';
                jqTds[4].innerHTML = '<input type="text" class="form-control small" value="' + aData[4] + '">';
                jqTds[5].innerHTML = '<input type="text" class="form-control small" value="' + aData[5] + '">';
                jqTds[6].innerHTML = '<a class="edit" href="">Enregistrer</a>';
                jqTds[7].innerHTML = '<a class="cancel" href="">Annuler</a>';
                $.ajax({
                    url: 'ListerDepartements',
                    data: {
                        idSite: aData[5]
                    },
                    success: function (responseJson) {
                        $('#ajaxGetUserServletResponse').text(responseJson);
                        $("#dept").empty();
                        //$('#departement').children('option:not(:first)').remove();
                        $.each(responseJson, function (key, value)
                        {
                            $('#dept').append('<option value=' + value['id'] + '>' + value['nom'] + '</option>');
                        });
                        $("#dept").val(aData[7]);

                    }
                });
                $.ajax({
                    url: 'ListerSites',

                    success: function (responseJson) {
                        $('#ajaxGetUserServletResponse').text(responseJson);
                        //$('#departement').children('option:not(:first)').remove();
                        $.each(responseJson, function (key, value)
                        {
                            $('#sites').append('<option value=' + value['id'] + '>' + value['nom'] + '</option>');
                        });
                        $("#sites").val(aData[5]);


                    }
                });
                $('#sites').blur(function () {
                    $.ajax({
                        url: 'ListerDepartements',
                        data: {
                            idSite: $('#sites').val()
                        },
                        success: function (responseJson) {
                            $('#ajaxGetUserServletResponse').text(responseJson);
                            $("#dept").empty();
                            $.each(responseJson, function (key, value)
                            {
                                $('#dept').append('<option value=' + value['id'] + '>' + value['nom'] + '</option>');
                            });

                        }
                    });
                });
            }

            function saveRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                var jqSelects = $('select', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 3, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 4, false);
                oTable.fnUpdate(jqSelects[0].value, nRow, 5, false);
                oTable.fnUpdate(jqSelects[0].options[jqSelects[0].selectedIndex].text, nRow, 6, false);
                oTable.fnUpdate(jqSelects[1].value, nRow, 7, false);
                oTable.fnUpdate(jqSelects[1].options[jqSelects[1].selectedIndex].text, nRow, 8, false);
                oTable.fnUpdate('<a class="edit" href="">Modifier</a>', nRow, 10, false);
                oTable.fnUpdate('<a class="delete" href="">Supprimer</a>', nRow, 11, false);
                oTable.fnDraw();
            }

            function cancelEditRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 3, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 4, false);
                oTable.fnUpdate(jqInputs[4].value, nRow, 5, false);
                oTable.fnUpdate(jqInputs[5].value, nRow, 6, false);
                oTable.fnUpdate(jqInputs[6].value, nRow, 7, false);
                oTable.fnUpdate(jqInputs[7].value, nRow, 8, false);
                oTable.fnUpdate('<a class="edit" href="">Modifier</a>', nRow, 10, false);
                oTable.fnDraw();
            }

            var oTable = $('#editable-sample').dataTable({
                "bSort" : false,
                "aLengthMenu": [
                    [5, 15, 20, -1],
                    [5, 15, 20, "All"] // change per page values here
                ],
                // set the initial value
                "iDisplayLength": 5,
                "sDom": "<'row'<'col-lg-6'l><'col-lg-6'f>r>t<'row'<'col-lg-6'i><'col-lg-6'p>>",
                "sPaginationType": "bootstrap",
                "oLanguage": {
                    "sLengthMenu": "_MENU_ enregistrements par page",
                    "oPaginate": {
                        "sPrevious": "Dern",
                        "sNext": "Suiv"
                    }
                },
                "aoColumnDefs": [{
                        'bSortable': false,
                        'aTargets': [0]
                    }
                ]
            });

            jQuery('#editable-sample_wrapper .dataTables_filter input').addClass("form-control medium"); // modify table search input
            jQuery('#editable-sample_wrapper .dataTables_length select').addClass("form-control xsmall"); // modify table per page dropdown

            var nEditing = null;

            $('#editable-sample_new').click(function (e) {
                e.preventDefault();
                var aiNew = oTable.fnAddData(['', '', '', '',
                    '<a class="edit" href="">Edit</a>', '<a class="cancel" data-mode="new" href="">Cancel</a>'
                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);
                editRow(oTable, nRow);
                nEditing = nRow;
            });

            $('#editable-sample a.delete').live('click', function (e) {
                e.preventDefault();

                if (confirm("Etes-vous sûr de supprimer ce réseau ?") == false) {
                    return;
                }

                var nRow = $(this).parents('tr')[0];
                var aData = oTable.fnGetData(nRow);
                $.ajax({
                    url: 'SupprimerReseau',
                    method: 'post',
                    data: {
                        id: aData[0]
                    }
                });
                oTable.fnDeleteRow(nRow);
                alert("Réseau Supprimé avec succes!");
            });

            $('#editable-sample a.cancel').live('click', function (e) {
                e.preventDefault();
                if ($(this).attr("data-mode") == "new") {
                    var nRow = $(this).parents('tr')[0];
                    oTable.fnDeleteRow(nRow);
                } else {
                    restoreRow(oTable, nEditing);
                    nEditing = null;
                }
            });

            $('#editable-sample a.edit').live('click', function (e) {
                e.preventDefault();

                /* Get the row as a parent of the link that was clicked on */
                var nRow = $(this).parents('tr')[0];

                if (nEditing !== null && nEditing != nRow) {
                    /* Currently editing - but not this row - restore the old before continuing to edit mode */
                    restoreRow(oTable, nEditing);
                    editRow(oTable, nRow);
                    nEditing = nRow;
                } else if (nEditing == nRow && this.innerHTML == "Enregistrer") {
                    /* Editing this row and want to save it */
                    
                    var aData = oTable.fnGetData(nRow);
                    saveRow(oTable, nEditing);
                    $.ajax({
                    url: 'ModifierReseau',
                    method: 'post',
                    data: {
                        id: aData[0],
                        adresse: aData[1],
                        masque: aData[2],
                        description: aData[3],
                        commentaire: aData[4],
                        iddepartement: aData[5]
                    }
                    });
                    nEditing = null;
                    alert("Réseau modifié avec succes!");
                } else {
                    /* No edit in progress - let's start one */
                    editRow(oTable, nRow);
                    nEditing = nRow;
                }
            });
        }

    };

}();

