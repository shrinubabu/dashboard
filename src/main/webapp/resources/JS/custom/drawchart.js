/**
 * Created by 26HW011447-PC on 5/20/2017.
 */
$(document).ready(function(){

    drawAllCharts();
        function drawAllCharts(quarter,chartId) {
            if(quarter == undefined || quarter == null || quarter == ""){
                quarter = "all";
            }

            $.get("/getRevenueByQuarter", function (data) {
                drawChart(data,quarter.toUpperCase());
            }).fail(function () {
                alert("error");
            });

            $.get("/getRevenueByQuarterByAccountLocationName?quarter="+quarter, function (data) {
                drawChart2(data,quarter.toUpperCase());
            }).fail(function () {
                alert("error");
            });

            $.get("/getRevenueByQuarterByHorizontal?quarter="+quarter, function (data) {
                drawChart3(data,quarter.toUpperCase());
            }).fail(function () {
                alert("error");
            });

            $.get("/getRevenueByQuarterBySP?quarter="+quarter, function (data) {
                drawChart4(data,quarter.toUpperCase());
            }).fail(function () {
                alert("error");
            });
        }

    $('span[id="refresh-btn"]').click(function(e){
            var chartId = $(e.target).parent().attr('chart-id');
            if(chartId == "chart1"){
                $.get("/getRevenueByQuarter", function (data) {
                    drawChart(data,'All');
                }).fail(function () {
                    alert("error");
                });
            }else if(chartId == "chart2"){
                $.get("/getRevenueByQuarterByAccountLocationName?quarter=all", function (data) {
                    drawChart2(data,'All');
                }).fail(function () {
                    alert("error");
                });
            }else if(chartId == "chart3"){
                $.get("/getRevenueByQuarterByHorizontal?quarter=all", function (data) {
                    drawChart3(data,'All');
                }).fail(function () {
                    alert("error");
                });
            }else if(chartId == "chart4"){
                $.get("/getRevenueByQuarterBySP?quarter=all", function (data) {
                    drawChart4(data,'All');
                }).fail(function () {
                    alert("error");
                });
            }
        });

    function drawChart(data){
        console.log('Draw chart Data '+data.length);
        var arrData = [];
        var legendArr = [];
        for(var i=0;i<data.length;i++){
            var amount = data[i].sumAmountUSDBEACON/1000000;
            var item = {value:amount.toFixed(2),label:{normal:{show:true,position:'top',formatter:'${c}'+'m',textStyle:{color:'#CE7057',fontSize:'13em'}}}};
            arrData.push(item);
            //arrData.push("{value:'"+data[i].sumAmountUSDBEACON+"',label:{normal:{show:true,position:'top'}}}");
            legendArr.push(data[i].quarter);
        }
        var myChart = echarts.init(document.getElementById('chart1'));

        // specify chart configuration item and data
        var option = {
            color: ['#5D9AD1'],
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis : [
                {
                    type : 'category',
                    data : legendArr,
                    axisTick: {
                        alignWithLabel: true
                    }
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'Revenue',
                    type:'bar',
                    barWidth: '60%',
                    data:arrData
                }
            ]
        };
        // use configuration item and data specified to show chart
        myChart.setOption(option);
        myChart.on('click', function (params) {
            // printing data name in console
            //console.log(params.name);console.log(params);
            drawAllCharts(params.name);
        });
    }

    function drawChart2(data,quarter){

        console.log('Draw chart Data '+data.length);
        var arrData = [];
        var legendArr = [];
        for(var i=0;i<data.length;i++){
            var item = {name:data[i].accountLocationName,value:data[i].sumAmountUSDBEACON};
            arrData.push(item);
            legendArr.push(data[i].accountLocationName);
        }

        var myChart = echarts.init(document.getElementById('chart2'));
        var option = {
            color:['#737373', '#F15A61', '#7CC26A', '#5D9AD1', '#FAA759', '#9F66AB', '#CE7057', '#D77EB4'],
            title : {
                text: 'Quarter '+quarter,
               /* subtext: 'Location Wise',*/
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
           /* legend: {
                orient: 'horizontal',
                left: 'center',
                data: legendArr
            },*/
            series : [
                {
                    name: 'Revenue',
                    type: 'pie',
                    radius : '75%',
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

    function drawChart3(data,quarter){

        console.log('Draw chart Data '+data.length);
        var arrData = [];
        var legendArr = [];
        for(var i=0;i<data.length;i++){
            var item = {name:data[i].serviceLine,value:data[i].sumAmountUSDBEACON};
            arrData.push(item);
            legendArr.push(data[i].serviceLine);
        }

        var myChart = echarts.init(document.getElementById('chart3'));
        var option = {
            color:['#737373', '#F15A61', '#7CC26A', '#5D9AD1', '#FAA759', '#9F66AB', '#CE7057', '#D77EB4'],
            title : {
                text: 'Quarter '+quarter,
                /*subtext: 'Location Wise',*/
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            /* legend: {
             orient: 'horizontal',
             left: 'center',
             data: legendArr
             },*/
            series : [
                {
                    name: 'Revenue',
                    type: 'pie',
                    radius : '75%',
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

    function drawChart4(data,quarter){

        console.log('Draw chart Data '+data.length);
        var arrData = [];
        var legendArr = [];
        for(var i=0;i<data.length;i++){
            var item = {name:data[i].sp,value:data[i].sumAmountUSDBEACON};
            arrData.push(item);
            legendArr.push(data[i].sp);
        }

        var myChart = echarts.init(document.getElementById('chart4'));
        var option = {
            color:['#737373', '#F15A61', '#7CC26A', '#5D9AD1', '#FAA759', '#9F66AB', '#CE7057', '#D77EB4'],
            title : {
                text: 'Quarter '+quarter,
                /*subtext: 'Location Wise',*/
                x:'center'
            },
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            /* legend: {
             orient: 'horizontal',
             left: 'center',
             data: legendArr
             },*/
            series : [
                {
                    name: 'Revenue',
                    type: 'pie',
                    radius : '75%',
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