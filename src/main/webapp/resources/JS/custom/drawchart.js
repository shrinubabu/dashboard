/**
 * Created by 26HW011447-PC on 5/20/2017.
 */
$(document).ready(function(){

        $.get( "/getSalesData", function(data) {
            alert( "success" );
            drawChart(data);
        }).fail(function() {
            alert( "error" );
        });

    function drawChart(data){
        console.log('Draw chart Data '+data);
        var arrData = [];
        var legendArr = [];
        for(var i=0;i<data.length;i++){
            var item = { name:data[i].itemName,value:data[i].salesCount};
            arrData.push(item);
            legendArr.push(data[i].itemName);
        }
        var myChart = echarts.init(document.getElementById('chart1'));

        // specify chart configuration item and data
        option = {
            title : {
                text: 'Garment Sales',
                subtext: 'Sales Pie Chart',
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: legendArr
            },
            series : [
                {
                    name: 'Sales',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:arrData,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        // use configuration item and data specified to show chart
        myChart.setOption(option);

        myChart.on('click', function (params) {
            // printing data name in console
            alert('You Clicked On '+params.name+' --> '+params.percent)
            console.log(params.name);console.log(params);
        });
    }



});