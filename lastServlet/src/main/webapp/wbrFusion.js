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
               "model": "12 Pro Max",
               "city": "San Francisco",
               "price": 5000
             },
                          {
               "month": "June",
               "model": "12 Pro Max",
               "city": "San Francisco",
               "price": 1400
             },
              {
               "month": "July",
               "model": "Iphone 10",
               "city": "New York City",
               "price": 1100
             },
              {
               "month": "August",
               "model": "Iphone 12",
               "city": "San Francisco",
               "price": 300
             },
              {
               "month": "September",
               "model": "12 Pro Max",
               "city": "San Francisco",
               "price": 200
             },
              {
               "month": "August",
               "model": "12 Pro Max",
               "city": "San Francisco",
               "price": 500
             },
              {
               "month": "October",
               "model": "12 Pro Max",
               "city": "San Francisco",
               "price": 700
             },
              {
               "month": "November",
               "model": "12 Pro Max",
               "city": "San Francisco",
               "price": 1700
             },
              {
               "month": "December",
               "model": "12 Pro Max",
               "city": "San Francisco",
               "price": 1500
             },
             {
               "month": "February",
               "model": "11",
               "city": "San Francisco",
               "price": 800
             },
             {
               "month": "June",
               "model": "13 Pro",
               "city": "San Francisco",
               "price": 1100
             },
             {
               "month": "April",
               "model": "11 Pro",
               "city": "San Francisco",
               "price": 1000
             },
             {
               "month": "April",
               "model": "12 Pro",
               "city": "San Francisco",
               "price": 800
             },
             {
               "month": "February",
               "model": "12",
               "city": "San Francisco",
               "price": 500
             },
             {
               "month": "April",
               "model": "11 Pro",
               "city": "San Francisco",
               "price": 1400
             },
             {
               "month": "April",
               "model": "8",
               "city": "San Francisco",
               "price": 600
             },
             ];}
             