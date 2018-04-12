/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var EditableTableDept = function () {

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
                console.log(JSON.stringify(oTable));
                alert(JSON.stringify(aData));
                var jqTds = $('>td', nRow);
                //jqTds[0].innerHTML = '<input type="text" class="form-control small" value="' + aData[0] + '">';
                jqTds[1].innerHTML = '<input type="text" class="form-control small" value="' + aData[1] + '">';
                jqTds[3].innerHTML = '<select id="sites" class="form-control small"></select>';
                jqTds[4].innerHTML = '<a class="edit" href=""><i class="fa fa-edit"></i></a>';
                jqTds[5].innerHTML = '<a class="cancel" href=""><i class="fa fa-undo"></i></a>';
                $.ajax({
                    url: 'ListerSites',

                    success: function (responseJson) {
                        $('#ajaxGetUserServletResponse').text(responseJson);
                        //$('#departement').children('option:not(:first)').remove();
                        $.each(responseJson, function (key, value)
                        {
                            $('#sites').append('<option value=' + value['id'] + '>' + value['nom'] + '</option>');
                        });
                        $("#sites").val(aData[2]);


                    }
                });
            }

            function saveRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                var jqSelects = $('select', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 1, false);
                oTable.fnUpdate(jqSelects[0].value, nRow, 2, false);
                oTable.fnUpdate(jqSelects[0].options[jqSelects[0].selectedIndex].text, nRow, 3, false);
                oTable.fnUpdate('<a class="edit" href=""><i class="fa fa-edit"></i></a>', nRow, 4, false);
                oTable.fnUpdate('<a class="delete" href=""><i class="fa fa-times"></i></a>', nRow, 5, false);
                oTable.fnDraw();
            }

            function cancelEditRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 1, false);
                oTable.fnUpdate(jqInputs[1].value, nRow, 2, false);
                oTable.fnUpdate(jqInputs[2].value, nRow, 3, false);
                oTable.fnUpdate(jqInputs[3].value, nRow, 4, false);
                oTable.fnUpdate(jqInputs[4].value, nRow, 5, false);
                oTable.fnUpdate('<a class="edit" href=""><i class="fa fa-edit"></i></a>', nRow, 6, false);
                oTable.fnDraw();
            }

            var oTable = $('#editable-sample').dataTable({
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
                    '<a class="edit" href=""><i class="fa fa-edit"></i></a>', '<a class="cancel" data-mode="new" href=""><i class="fa fa-undo"></i></a>'
                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);
                editRow(oTable, nRow);
                nEditing = nRow;
            });

            $('#editable-sample a.delete').live('click', function (e) {
                e.preventDefault();

                if (confirm("Etes-vous sûr de supprimer ce département ?") == false) {
                    return;
                }

                var nRow = $(this).parents('tr')[0];
                var aData = oTable.fnGetData(nRow);
                $.ajax({
                    url: 'SupprimerDepartements',
                    method: 'post',
                    data: {
                        id: aData[0]
                    }
                });
                oTable.fnDeleteRow(nRow);
                alert("Departement Supprimé avec succes!");
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
                } else if (nEditing == nRow && this.innerHTML == '<i class="fa fa-edit"></i>') {
                    /* Editing this row and want to save it */

                    var aData = oTable.fnGetData(nRow);
                    saveRow(oTable, nEditing);
                    $.ajax({
                        url: 'ModifierDepartements',
                        method: 'post',
                        data: {
                            id: aData[0],
                            nom: aData[1],
                            idsite: aData[2]
                        }
                    });
                    nEditing = null;
                    alert("Département modifié avec succes!");
                } else {
                    /* No edit in progress - let's start one */
                    editRow(oTable, nRow);
                    nEditing = nRow;
                }
            });
        }

    };

}();
var EditableTableSite = function () {

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
                jqTds[1].innerHTML = '<input type="text" class="form-control small" value="' + aData[1] + '">';
                jqTds[2].innerHTML = '<a class="edit" href=""><i class="fa fa-edit"></i></a>';
                jqTds[3].innerHTML = '<a class="cancel" href=""><i class="fa fa-undo"></i></a>';
            }

            function saveRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 1, false);
                oTable.fnUpdate('<a class="delete" href=""><i class="fa fa-times"></i></a>', nRow, 3, false);
                oTable.fnDraw();
            }

            function cancelEditRow(oTable, nRow) {
                var jqInputs = $('input', nRow);
                oTable.fnUpdate(jqInputs[0].value, nRow, 1, false);
                oTable.fnUpdate('<a class="edit" href=""><i class="fa fa-edit"></i></a>', nRow, 3, false);
                oTable.fnDraw();
            }

            var oTable = $('#editable-sample-site').dataTable({
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

            jQuery('#editable-sample-site_wrapper .dataTables_filter input').addClass("form-control medium"); // modify table search input
            jQuery('#editable-sample-site_wrapper .dataTables_length select').addClass("form-control xsmall"); // modify table per page dropdown

            var nEditing = null;

            $('#editable-sample-site_new').click(function (e) {
                e.preventDefault();
                var aiNew = oTable.fnAddData(['', '', '', '',
                    '<a class="edit" href="">Edit</a>', '<a class="cancel" data-mode="new" href="">Cancel</a>'
                ]);
                var nRow = oTable.fnGetNodes(aiNew[0]);
                editRow(oTable, nRow);
                nEditing = nRow;
            });

            $('#editable-sample-site a.delete').live('click', function (e) {
                e.preventDefault();

                if (confirm("Etes-vous sûr de supprimer ce site ?") == false) {
                    return;
                }

                var nRow = $(this).parents('tr')[0];
                var aData = oTable.fnGetData(nRow);
                $.ajax({
                    url: 'SupprimerSites',
                    method: 'post',
                    data: {
                        id: aData[0]
                    },
                    success: function (responseJson) {
                        $('#editable-sample tbody').empty();
                        $.ajax({
                            url: 'ListerDepartements',

                            success: function (responseJson) {
                                $('#ajaxGetUserServletResponse').text(responseJson);
                                //$('#departement').children('option:not(:first)').remove();
                                var tr;
                                $.each(responseJson, function (key, value)
                                {
                                    tr = $('<tr class=" "/>');
                                    tr.append("<td>" + value.id  + "</td>");
                                    tr.append("<td>" + value.nom + "</td>");
                                    tr.append('<td style="display:none;">' + value.site.id + '</td>');
                                    tr.append("<td>" + value.site.nom + "</td>");
                                    tr.append('<td><a class="edit" href="javascript:;"><i class="fa fa-edit"></i></a></td>');
                                    tr.append('<td><a class="delete" href="javascript:;"><i class="fa fa-times"></i></a></td>');
                                    $('#editable-sample tbody').append(tr);
                                });

                            }
                        });
                    }
                });
                oTable.fnDeleteRow(nRow);
                alert("Site supprimé avec succes!");
            });

            $('#editable-sample-site a.cancel').live('click', function (e) {
                e.preventDefault();
                if ($(this).attr("data-mode") == "new") {
                    var nRow = $(this).parents('tr')[0];
                    oTable.fnDeleteRow(nRow);
                } else {
                    restoreRow(oTable, nEditing);
                    nEditing = null;
                }
            });

            $('#editable-sample-site a.edit').live('click', function (e) {
                e.preventDefault();

                /* Get the row as a parent of the link that was clicked on */
                var nRow = $(this).parents('tr')[0];

                if (nEditing !== null && nEditing != nRow) {
                    /* Currently editing - but not this row - restore the old before continuing to edit mode */
                    restoreRow(oTable, nEditing);
                    editRow(oTable, nRow);
                    nEditing = nRow;
                } else if (nEditing == nRow && this.innerHTML == '<i class="fa fa-edit"></i>') {
                    /* Editing this row and want to save it */

                    var aData = oTable.fnGetData(nRow);
                    saveRow(oTable, nEditing);
                    $.ajax({
                        url: 'ModifierSites',
                        method: 'post',
                        data: {
                            id: aData[0],
                            nom: aData[1]
                        },
                        success: function (responseJson) {
                            $('#editable-sample tbody').empty();
                            $.ajax({
                                url: 'ListerDepartements',

                                success: function (responseJson) {
                                    $('#ajaxGetUserServletResponse').text(responseJson);
                                    //$('#departement').children('option:not(:first)').remove();
                                    $.each(responseJson, function (key, value)
                                    {
                                        $('#editable-sample tbody').append('<tr class=" "><td   class="  sorting_1">' + value.id + '</td><td class=" ">' + value.nom + '</td><td style="display:none;" class=" ">' + value.site.id + '</td><td class=" ">' + value.site.nom
                                                + '</td><td><a class="edit" href="javascript:;"><i class="fa fa-edit"></i></a></td><td><a class="delete" href="javascript:;"><i class="fa fa-times"></i></a></td></tr>');
                                    });


                                }
                            });
                        }

                    });
                    nEditing = null;
                    alert("Site modifié avec succes!");
                } else {
                    /* No edit in progress - let's start one */
                    editRow(oTable, nRow);
                    nEditing = nRow;
                }
            });
        }

    };

}();

