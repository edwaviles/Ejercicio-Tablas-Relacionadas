  $(document).ready(function ()
  {
      /*var chart = new CanvasJS.Chart("chartContainer",
        {
           title:{
            text: "Golds won in 2012 London Olympics", 
            fontWeight: "bolder",
            fontColor: "#008B8B",
            fontfamily: "tahoma",        
            fontSize: 25,
            padding: 10        
          },

          data: [
          {        
            type: "column",
            dataPoints: [
             {label: "US", y: 46 },
             {label: "China", y: 38},
             {label: "Britain", y: 29},
             {label: "Russia", y: 24 },
             {label: "South Korea", y: 13 },
             {label: "Germany", y: 11 },
             {label: "france", y: 11},
             {label: "Hungary", y: 8 },
             {label: "Australia", y: 7 },
             {label: "Japan", y: 7 }      
          ]
           }
          ]
        });

     chart.render();*/
      
/*      var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light2", // "light1", "light2", "dark1", "dark2"
	exportEnabled: true,
	animationEnabled: true,
	title: {
		text: "Desktop Browser Market Share in 2016"
	},
	data: [{
		type: "pie",
		startAngle: 25,
		toolTipContent: "<b>{label}</b>: {y}%",
		showInLegend: "true",
		legendText: "{label}",
		indexLabelFontSize: 16,
		indexLabel: "{label} - {y}%",
		dataPoints: [
			{ y: 51.08, label: "Chrome" },
			{ y: 27.34, label: "Internet Explorer" },
			{ y: 10.62, label: "Firefox" },
			{ y: 5.02, label: "Microsoft Edge" },
			{ y: 4.07, label: "Safari" },
			{ y: 1.22, label: "Opera" },
			{ y: 0.44, label: "Others" }
		]
	}]
});
chart.render();*/
      

/*      
      var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	title:{
		text: "Daily High Temperature at Different Beaches"
	},
	axisX: {
		valueFormatString: "DD MMM,YY"
	},
	axisY: {
		title: "Temperature (in °C)",
		includeZero: false,
		suffix: " °C"
	},
	legend:{
		cursor: "pointer",
		fontSize: 16,
		itemclick: toggleDataSeries
	},
	toolTip:{
		shared: true
	},
	data: [{
		name: "Myrtle Beach",
		type: "spline",
		yValueFormatString: "#0.## °C",
		showInLegend: true,
		dataPoints: [
			{ x: new Date(2017,6,24), y: 31 },
			{ x: new Date(2017,6,25), y: 31 },
			{ x: new Date(2017,6,26), y: 29 },
			{ x: new Date(2017,6,27), y: 29 },
			{ x: new Date(2017,6,28), y: 31 },
			{ x: new Date(2017,6,29), y: 30 },
			{ x: new Date(2017,6,30), y: 29 }
		]
	},
	{
		name: "Martha Vineyard",
		type: "spline",
		yValueFormatString: "#0.## °C",
		showInLegend: true,
		dataPoints: [
			{ x: new Date(2017,6,24), y: 20 },
			{ x: new Date(2017,6,25), y: 20 },
			{ x: new Date(2017,6,26), y: 25 },
			{ x: new Date(2017,6,27), y: 25 },
			{ x: new Date(2017,6,28), y: 25 },
			{ x: new Date(2017,6,29), y: 25 },
			{ x: new Date(2017,6,30), y: 25 }
		]
	},
	{
		name: "Nantucket",
		type: "spline",
		yValueFormatString: "#0.## °C",
		showInLegend: true,
		dataPoints: [
			{ x: new Date(2017,6,24), y: 22 },
			{ x: new Date(2017,6,25), y: 19 },
			{ x: new Date(2017,6,26), y: 23 },
			{ x: new Date(2017,6,27), y: 24 },
			{ x: new Date(2017,6,28), y: 24 },
			{ x: new Date(2017,6,29), y: 23 },
			{ x: new Date(2017,6,30), y: 23 }
		]
	}]
});
chart.render();*/

/*
      var dps = []; // dataPoints
        var chart = new CanvasJS.Chart("chartContainer", {
                title :{
                        text: "Dynamic Data"
                },
                axisY: {
                        includeZero: false
                },      
                data: [{
                        type: "line",
                        dataPoints: dps
                }]
        });

        var xVal = 0;   
        var yVal = 100; 
        var updateInterval = 1000;
        var dataLength = 20; // number of dataPoints visible at any point

        var updateChart = function (count) {

                count = count || 1;

                for (var j = 0; j < count; j++) {
                        yVal = yVal +  Math.round(5 + Math.random() *(-5-5));
                        dps.push({
                                x: xVal,
                                y: yVal
                        });
                        xVal++;
                }

                if (dps.length > dataLength) {
                        dps.shift();
                }

                chart.render();
        };

        updateChart(dataLength);
        setInterval(function(){updateChart()}, updateInterval);
*/
/*
var dataPoints = [];

var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	theme: "light2",
	title: {
		text: "Daily Sales Data"
	},
	axisY: {
		title: "Units",
		titleFontSize: 24
	},
	data: [{
		type: "column",
		yValueFormatString: "#,### Units",
		dataPoints: dataPoints
	}]
});

function addData(data) {
	for (var i = 0; i < data.length; i++) {
		dataPoints.push({
			x: new Date(data[i].date),
			y: data[i].units
		});
	}
	chart.render();

}

$.getJSON("https://canvasjs.com/data/gallery/javascript/daily-sales-data.json", addData);
*/


var chart = new CanvasJS.Chart("chartContainer", {
	//theme: "light2", // "light1", "light2", "dark1", "dark2"
	animationEnabled: true,
	title:{
		text: "Internet users"  
	},
	subtitles: [{
		text: "Try Clicking and Hovering over Legends!"
	}],
	axisX: {
		lineColor: "black",
		labelFontColor: "black"
	},
	axisY2: {
      	gridThickness: 0,
		title: "% of Population",
		suffix: "%",
		titleFontColor: "black",
		labelFontColor: "black"
	},
	legend: {
		cursor: "pointer",
		itemmouseover: function(e) {
			e.dataSeries.lineThickness = e.chart.data[e.dataSeriesIndex].lineThickness * 2;
			e.dataSeries.markerSize = e.chart.data[e.dataSeriesIndex].markerSize + 2;
			e.chart.render();
		},
		itemmouseout: function(e) {
			e.dataSeries.lineThickness = e.chart.data[e.dataSeriesIndex].lineThickness / 2;
			e.dataSeries.markerSize = e.chart.data[e.dataSeriesIndex].markerSize - 2;
			e.chart.render();
		},
		itemclick: function (e) {
			if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
				e.dataSeries.visible = false;
			} else {
				e.dataSeries.visible = true;
			}
			e.chart.render();
		}
	},
	toolTip: {
		shared: true
	},
	data: [{
		type: "spline",
		name: "Sweden",
		markerSize: 5,
      	axisYType: "secondary",
		xValueFormatString: "YYYY",
		yValueFormatString: "#,##0.0\"%\"",
		showInLegend: true,
		dataPoints: [
			{ x: new Date(2000, 00), y: 47.5 },
			{ x: new Date(2005, 00), y: 84.8 },
			{ x: new Date(2009, 00), y: 91 },
			{ x: new Date(2010, 00), y: 90 },
			{ x: new Date(2011, 00), y: 92.8 },
			{ x: new Date(2012, 00), y: 93.2 },
			{ x: new Date(2013, 00), y: 94.8 },
			{ x: new Date(2014, 00), y: 92.5 }
		]
	},
	{
		type: "spline",
		name: "UK",
		markerSize: 5,
		axisYType: "secondary",
		xValueFormatString: "YYYY",
		yValueFormatString: "#,##0.0\"%\"",
		showInLegend: true,
		dataPoints: [
			{ x: new Date(2000, 00), y: 26.8 },
			{ x: new Date(2005, 00), y: 70 },
			{ x: new Date(2009, 00), y: 83.6 },
			{ x: new Date(2010, 00), y: 85 },
			{ x: new Date(2011, 00), y: 85.4 },
			{ x: new Date(2012, 00), y: 87.5 },
			{ x: new Date(2013, 00), y: 89.8 },
			{ x: new Date(2014, 00), y: 91.6 }
		]
	},
	{
		type: "spline",
		name: "UAE",
		markerSize: 5,
		axisYType: "secondary",
		xValueFormatString: "YYYY",
		yValueFormatString: "#,##0.0\"%\"",
		showInLegend: true,
		dataPoints: [
			{ x: new Date(2000, 00), y: 23.6 },
			{ x: new Date(2005, 00), y: 40 },
			{ x: new Date(2009, 00), y: 64 },
			{ x: new Date(2010, 00), y: 68 },
			{ x: new Date(2011, 00), y: 78 },
			{ x: new Date(2012, 00), y: 85 },
			{ x: new Date(2013, 00), y: 86 },
			{ x: new Date(2014, 00), y: 90.4 }
		]
	},
	{
		type: "spline",
		showInLegend: true,
		name: "USA",
		markerSize: 5,
		axisYType: "secondary",
		yValueFormatString: "#,##0.0\"%\"",
		xValueFormatString: "YYYY",
		dataPoints: [
			{ x: new Date(2000, 00), y: 43.1 },
			{ x: new Date(2005, 00), y: 68 },
			{ x: new Date(2009, 00), y: 71 },
			{ x: new Date(2010, 00), y: 71.7 },
			{ x: new Date(2011, 00), y: 69.7 },
			{ x: new Date(2012, 00), y: 79.3 },
			{ x: new Date(2013, 00), y: 84.2 },
			{ x: new Date(2014, 00), y: 87 }
		]
	},
	{
		type: "spline",
		name: "Switzerland",
		markerSize: 5,
		axisYType: "secondary",
		xValueFormatString: "YYYY",
		yValueFormatString: "#,##0.0\"%\"",
		showInLegend: true,
		dataPoints: [
			{ x: new Date(2000, 00), y: 47.1 },
			{ x: new Date(2005, 00), y: 70.1 },
			{ x: new Date(2009, 00), y: 81.3 },
			{ x: new Date(2010, 00), y: 83.9 },
			{ x: new Date(2011, 00), y: 85.2 },
			{ x: new Date(2012, 00), y: 85.2 },
			{ x: new Date(2013, 00), y: 86.7 },
			{ x: new Date(2014, 00), y: 87 }
		]
	},
	{
		type: "spline",
		name: "Honk Kong",
		markerSize: 5,
		axisYType: "secondary",
		xValueFormatString: "YYYY",
		yValueFormatString: "#,##0.0\"%\"",
		showInLegend: true,
		dataPoints: [
			{ x: new Date(2000, 00), y: 27.8 },
			{ x: new Date(2005, 00), y: 56.9 },
			{ x: new Date(2009, 00), y: 69.4 },
			{ x: new Date(2010, 00), y: 72 },
			{ x: new Date(2011, 00), y: 72.2 },
			{ x: new Date(2012, 00), y: 72.9 },
			{ x: new Date(2013, 00), y: 74.2 },
			{ x: new Date(2014, 00), y: 74.6 }
		]
	},
	{
		type: "spline",
		name: "Russia",
		markerSize: 5,
		axisYType: "secondary",
		xValueFormatString: "YYYY",
		yValueFormatString: "#,##0.0\"%\"",
		showInLegend: true,
		dataPoints: [
			{ x: new Date(2000, 00), y: 2 },
			{ x: new Date(2005, 00), y: 15.2 },
			{ x: new Date(2009, 00), y: 29 },
			{ x: new Date(2010, 00), y: 43 },
			{ x: new Date(2011, 00), y: 49 },
			{ x: new Date(2012, 00), y: 63.8 },
			{ x: new Date(2013, 00), y: 61.4 },
			{ x: new Date(2014, 00), y: 70.5 }
		]
	},
	{
		type: "spline",
		name: "Ukraine",
		markerSize: 5,
		axisYType: "secondary",
		xValueFormatString: "YYYY",
		yValueFormatString: "#,##0.0\"%\"",
		showInLegend: true,
		dataPoints: [
			{ x: new Date(2000, 00), y: .7 },
			{ x: new Date(2005, 00), y: 3.7 },
			{ x: new Date(2009, 00), y: 17.9 },
			{ x: new Date(2010, 00), y: 23.3 },
			{ x: new Date(2011, 00), y: 28.7 },
			{ x: new Date(2012, 00), y: 35.3 },
			{ x: new Date(2013, 00), y: 41.8 },
			{ x: new Date(2014, 00), y: 43.4 }
		]
	},
	{
		type: "spline",
		name: "India",
		markerSize: 5,
		axisYType: "secondary",
		xValueFormatString: "YYYY",
		yValueFormatString: "#,##0.0\"%\"",
		showInLegend: true,
		dataPoints: [
			{ x: new Date(2000, 00), y: .5 },
			{ x: new Date(2005, 00), y: 2.4 },
			{ x: new Date(2009, 00), y: 5.1 },
			{ x: new Date(2010, 00), y: 7.5 },
			{ x: new Date(2011, 00), y: 10.1 },
			{ x: new Date(2012, 00), y: 12.6 },
			{ x: new Date(2013, 00), y: 15.1 },
			{ x: new Date(2014, 00), y: 18 }
		]
	}]
});
chart.render();

  });