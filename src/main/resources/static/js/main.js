$(function(){
	$('.popup-action').on('click', function(event){
		event.preventDefault();
		$('.popup-content').hide();
		var id = $(this).attr('data-id');
		$('.popup-wrapper').fadeIn(500, function(){
			$('#'+id).fadeIn();
		});
	});

	$('.popup-close').on('click', function(event){
		event.preventDefault();
		$('.popup-content').hide();
		$('.popup-wrapper').fadeOut();
	});
})

$(document).ready(function(){
	
$('.calculatelesswt').change(function () {
    $('#lesswt').val(parseFloat("0"+$('#grosswt').val()) - parseFloat("0"+$('#netwt').val()));
});
$('.calculateamount').change(function () {
	
	var gross = parseFloat("0"+$('#grosswt').val());
	var wastage =  parseFloat("0"+$('#wastage').val());
	var rate = parseFloat("0"+$('#rate').val());
	var mc = parseFloat("0"+$('#mc').val());
	var othcharge = parseFloat("0"+$('#otherCharge').val());
	var purchasetax = parseFloat("0"+$('#purchasetax').val());
	var wastagewt = (gross/100) * wastage ;
	var totwt = gross + wastagewt ;
	var subtotamt = totwt * rate;
	var taxableamt = subtotamt + mc + othcharge;
	var taxamount = (taxableamt/100) * purchasetax ; 
	var totalamount = taxableamt + taxamount
	var collectableamount = Math.round(totalamount.toFixed(2))
	$('#amount').val(collectableamount.toFixed(2));
	var roundofamount = collectableamount - totalamount
	$('#roundofamt').val(roundofamount.toFixed(2));

 });

var listPurchase = [];

$('.add-tr-row').on('click', function(event){
    event.preventDefault();
    
     var purchase = {
    		dealerName : $('#dealername').val(),
    		dealerCompany : $('#dealercompany').val(),
    		piece : $('#piece').val(),
    		grossWt : $('#grosswt').val(),
    		netWt : $('#netwt').val(),
    		lessWt : $('#lesswt').val(),
    		rate : $('#rate').val(),
    		wastage : $('#wastage').val(),
    		makingCharge : $('#mc').val(),
    		purchaseTaxPercent : $('#purchasetax').val(),
    		discount : $('#discount').val(),
    		otherCharge : $('#otherCharge').val(),
    		roundOfAmount : $('#roundofamt').val(), 
    		amount : $('#amount').val(),
    		purchaseType : $('#purchasetype').val(),
    		billRefno: $('#billrefno').val(),
    		billRefDate : $('#billrefdate').val(),
    		billStatus : $('#billstatus').val(),
    		description : $('#description').val()
    }
    listPurchase.push(purchase);
    
	var newRow = '<tr>' +
	 '<td class="text-center">' +
 	'<input type="hidden" value=' + (listPurchase.length - 1) + '>' +
 	'<a>' +
				'<img src="../static/images/close-black.png" alt="X">' +
		'</a>' +
 '</td>' +
	'<td>' + listPurchase.length + '</td>' +
	'<td>' + purchase.dealerName + '</td>' +
	'<td>' + purchase.dealerCompany + '</td>' +
	'<td>' + purchase.piece + '</td>' +
	'<td>' + purchase.grossWt + '</td>' +
	'<td>' + purchase.netWt + '</td>' +
	'<td>' + purchase.lessWt + '</td>' +
	'<td>' + purchase.rate + '</td>' +
	'<td>' + purchase.wastage + '</td>' +
	'<td>' + purchase.makingCharge + '</td>' +
	'<td>' + purchase.purchaseTaxPercent + '</td>' +
	'<td>' + purchase.discount + '</td>' +
	'<td>' + purchase.otherCharge + '</td>' +
	'<td>' + purchase.roundOfAmount + '</td>' +
	'<td>' + purchase.amount + '</td>' +
	'<td>' + purchase.purchaseType + '</td>' +
	'<td>' + purchase.billRefno + '</td>' +
	'<td>' + purchase.billRefDate + '</td>' +
	'<td>' + purchase.billStatus + '</td>' +
	'<td>' + purchase.description + '</td>' +
  '</tr>';
    
    $('.table-wrapper table tbody').append(newRow);
    $('.form-section').find('.text-box').val('');
    $('.popup-content').hide();
	$('.popup-wrapper').fadeOut();

});

// Do DELETE a Customer via JQUERY AJAX
$(document).on("click","a",function() {
	var customerId = $(this).parent().find('input').val();
	$(this).closest("tr").remove()
});

$('#postCustomersBtn').click(function(){
	ajaxPost();
});

function ajaxPost(){
	
	// DO POST
	$.ajax({
		type : "POST",
		contentType : "application/json",
		accept: 'text/plain',
		url : "http://localhost:8083/app/purchase/save",
		alert(listPurchase);
		data : JSON.stringify(listPurchase),
		dataType: 'text',
		success : function(result) {
			// clear customer body
			$('.table-wrapper table tbody').empty();
			//$('#customerTable').hide();
			
			// re-set customer table list
			listPurchase = [];
			
			// fill successfully message on view
			$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
										result +
									  "</p>");
		},
		error : function(e) {
			alert("Error!")
			console.log("ERROR: ", e);
		}
	});
}

});