/**
 * Created by 26HW011447-PC on 6/1/2017.
 */
$(document).ready(function () {

    var dataSet = [[1,'External Stakeholders','Customer Red Projects','M','2014-Oct','#','0','0','0','0','Green-image','0','0','grey-image','',''],
        [2,'External Stakeholders','Customer Satisfcation','H','H1-FY 15','%','96.35','95','95','-1.35','Green-image','96.35','0','grey-image','',''],
        [3,'Internal Process','Total Head Count','M','2014-Oct','#','443','460','460','17','Amber-image','452','-2.0%','red down trend image','Senior Releases',''],
        [4,'External Stakeholders','Customer Red Projects','M','2014-Oct','#','0','0','0','0','Green-image','0','0','grey-image','',''],
        [6,'External Stakeholders','Customer Red Projects','M','2014-Oct','#','0','0','0','0','Green-image','0','0','grey-image','',''],
        [7,'External Stakeholders','Customer Red Projects','M','2014-Oct','#','0','0','0','0','Green-image','0','0','grey-image','',''],
        [8,'External Stakeholders','Customer Red Projects','M','2014-Oct','#','0','0','0','0','Green-image','0','0','grey-image','',''],
        [9,'External Stakeholders','Customer Red Projects','M','2014-Oct','#','0','0','0','0','Green-image','0','0','grey-image','',''],
        [10,'External Stakeholders','Customer Red Projects','M','2014-Oct','#','0','0','0','0','Green-image','0','0','grey-image','','']];


    $('#score-card-table').DataTable( {
            data: dataSet
        } );

    /*The UL list in the dropdown should be constructed based on Ajax output and then appended to the first row after table is generated
    * and an onclick event also needs to be written to set the selected element in current dropdown and then create further dropdown elements based on dataset*/
    var htmlDropDown = `<div class="dropdown" id="Geography">
    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">Geography
    <span class="caret"></span></button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">ME</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Africa</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Asia Pacific</a></li>
    </ul>
  </div>`;

    $('#score-card-table_wrapper > div:nth-child(1) > div:nth-child(1)').after(htmlDropDown);
    $('#score-card-table_wrapper > div:nth-child(1) > div:nth-child(1)').after(htmlDropDown);
    $('#score-card-table_wrapper > div:nth-child(1) > div:nth-child(1)').after(htmlDropDown);

});