var pivot = new WebDataRocks({
    container: "#wdr-component",
    toolbar: false,
    "height": 400,
    report: {
        "dataSource": {
            "dataSourceType": "json",
            "data": getJSONData()
        },
        "slice": {
             "rows": [{
                 "uniqueName": "city"
             },
             {
            "uniqueName": "Measures"
            }],
            "columns": [{
                "uniqueName": "month"
            }],
            "measures": [{
                "uniqueName": "price",
                "aggregation": "sum"
            }]
        }
    },
    reportcomplete: function() {
        pivot.off("reportcomplete");
        createAreaChart();
        createBarChart();
        createPieChart();
    }
});

function createAreaChart() {
    var chart = new FusionCharts({
        type: "area2d",
        renderAt: "fusionchartArea",
        width: "100%",
        height: 400
    });
    pivot.fusioncharts.getData({
    type: chart.chartType(), "slice": {
        "rows": [
            {
                "uniqueName": "[Measures]"
            }
        ],
        "columns": [
            {
                "uniqueName": "month"
            }
        ],
        "measures": [
            {
                "uniqueName": "price",
                "aggregation": "sum"
            }
        ]
    }
	}, function(data) {
        chart.setJSONData(data);
        chart.setChartAttribute("theme", "fusion");
        chart.setChartAttribute("caption", "Total Revenue by Month");
        chart.render();
    });
}

function createBarChart() {
    var chart = new FusionCharts({
        type: "bar2d",
        renderAt: "fusionchartBar",
        width: "100%",
        height: 400
    });
    pivot.fusioncharts.getData({
    type: chart.chartType(), "slice": {
        "rows": [
            {
                "uniqueName": "[Measures]"
            }
        ],
        "columns": [
            {
                "uniqueName": "model"
            }
        ],
        "measures": [
            {
                "uniqueName": "price",
                "aggregation": "sum"
            }
        ]
    }
	},
	function(data) {
        chart.setJSONData(data);
        chart.setChartAttribute("theme", "fusion");
        chart.setChartAttribute("caption", "Total Revenue for Each Model");
        chart.setChartAttribute("paletteColors", "#bc5cdb, #493999, #8790a8");
        chart.render();
    }

    );
}

function createPieChart() {
    var chart = new FusionCharts({
        type: "pie2d",
        renderAt: "fusionchartPie",
        width: "100%",
        height: 400
    });
    pivot.fusioncharts.getData({
        type: chart.chartType()
        }, function(data) {
        chart.setJSONData(data);
        chart.setChartAttribute("theme", "fusion");
        chart.setChartAttribute("caption", "Total Revenue by City");
        chart.setChartAttribute("paletteColors", "#9d87f5, #faa27f, #9afa7f, #e37ffa, #7de1fa, #f8fa7f");
        chart.render();
    });
}


function getJSONData() {
    return [
             {
               "month": "January",
               "model": "11 Pro Max",
               "city": "Los Angeles",
               "price": 1000
             },
             {
               "month": "February",
               "model": "XR",
               "city": "Los Angeles",
               "price": 700
             },
             {
               "month": "March",
               "model": "12 Pro Max",
               "city": "Los Angeles",
               "price": 1100
             },
             {
               "month": "April",
               "model": "11",
               "city": "Los Angeles",
               "price": 1000
             },
             {
               "month": "May",
               "model": "13",
               "city": "Los Angeles",
               "price": 700
             },
             {
               "month": "June",
               "model": "12 Pro Max",
               "city": "Los Angeles",
               "price": 800
             },
             {
               "month": "February",
               "model": "12",
               "city": "Los Angeles",
               "price": 600
             },
             {
               "month": "April",
               "model": "11 Pro",
               "city": "Los Angeles",
               "price": 1400
             },
             {
               "month": "May",
               "model": "X",
               "city": "Los Angeles",
               "price": 1000
             },
             {
               "month": "May",
               "model": "13 Pro",
               "city": "Los Angeles",
               "price": 800
             },
             {
               "month": "June",
               "model": "12 Pro Max",
               "city": "Los Angeles",
               "price": 600
             },
             {
               "month": "June",
               "model": "11 Pro",
               "city": "Los Angeles",
               "price": 1400
             },
             {
               "month": "March",
               "model": "X",
               "city": "Los Angeles",
               "price": 1000
             },
             {
               "month": "March",
               "model": "13 Pro",
               "city": "Los Angeles",
               "price": 500
             },
             {
               "month": "June",
               "model": "12 Pro Max",
               "city": "Los Angeles",
               "price": 1400
             },
             {
               "month": "January",
               "model": "8 Plus",
               "city": "Los Angeles",
               "price": 600
             },
             {
               "month": "June",
               "model": "13 Pro",
               "city": "Los Angeles",
               "price": 1000
             },
             {
               "month": "June",
               "model": "13 Pro Max",
               "city": "Los Angeles",
               "price": 700
             },
             {
               "month": "May",
               "model": "13 Pro Max",
               "city": "Los Angeles",
               "price": 1000
             },
             
             ]
             }
             