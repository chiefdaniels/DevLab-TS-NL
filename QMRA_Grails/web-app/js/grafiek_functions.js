/**
 * 
 */

var d1 = [];
		
function $addItem($i, $dag, $aantal) 
{
	d1[$i] = [$dag,$aantal]				
};

function $displayFlot() 
{
    $.plot($("#placeholder_flot"), [ d1 ]);
};