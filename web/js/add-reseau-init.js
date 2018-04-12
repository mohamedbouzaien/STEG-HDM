/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
	$('#site').blur(function() {
		$.ajax({
			url : 'ListerDepartements',
			data : {
				idSite : $('#site').val()
			},
			success : function(responseJson) {
				$('#ajaxGetUserServletResponse').text(responseJson);
                                $('#departement').children('option:not(:first)').remove();
                                $.each(responseJson,function(key, value) 
                                {
                                    $('#departement').append('<option value=' + value['id'] + '>' + value['nom'] + '</option>');
                                });
                                
			}
		});
	});
});


