// anychart.onDocumentReady(function () {
// create data set on our data
var dataSet = anychart.data.set(getData());

// map data for the first series, take x from the zero column and value from the first column of data set
var firstSeriesData = dataSet.mapAs({x: 0, value: 1});

// map data for the second series, take x from the zero column and value from the second column of data set
var secondSeriesData = dataSet.mapAs({x: 0, value: 2});

// create line chart
var chart = anychart.line();

// adding dollar symbols to yAxis labels
chart.yAxis().labels().format('${%Value}');

// turn on chart animation
chart.animation(true);
chart.xAxis(true);
chart.yAxis(false);

// turn on the crosshair
// chart
//     .crosshair()
//     .enabled(true)
//     .yLabel({ enabled: false })
//     .yStroke(null)
//     .xStroke('#cecece')
//     .zIndex(99);

// chart
//     .yAxis()
//     .title('The Share Price')
//     .labels({ padding: [5, 5, 0, 5] });

// chart.xAxis().title('Month/Day');

// set chart title text settings

// create first series with mapped data
var firstSeries = chart.spline(firstSeriesData);
// firstSeries.name('ACME Share Price');
firstSeries.markers().zIndex(100);
firstSeries.hovered().markers().enabled(true).type('circle').size(4);


// create second series with mapped data
var secondSeries = chart.spline(secondSeriesData);
// secondSeries.name('The Competitor\'s Share Price');
secondSeries.markers().zIndex(100);
secondSeries.color('#3c1b85')
secondSeries.hovered().markers().enabled(true).type('circle').size(4);

// turn the legend on
// chart.legend().enabled(true).fontSize(13).padding([0, 0, 20, 0]);

// set container id for the chart
chart.container('container');

// initiate chart drawing
chart.draw();

function getData() {
    return [
        ['Jan', , 2.65],
        ['Feb', , 2.62],
        ['Mar', , 2.59],
        ['Apr', , 2.56],
        ['May', , 2.57],
        ['Jun', , 2.55],
        ['Jul', , 2.56],
        ['Aug', , 2.66],
        ['Sep', , 2.79],
        ['Oct', , 2.87],
        ['Nov', , 2.81],
        ['Dec', , 2.75]
    ];
}