// Wrapping in nv.addGraph allows for '0 timeout render', stores rendered charts in nv.graphs, and may do more in the future... it's NOT required
    var chart;
    var colors = ["#ff7f0e","#2ca02c","#2222ff","#667711","#EF9CFB"];
	//var data = [{values: [{x:50,y:0.026843000203371048},{x:100,y:0.002764000091701746},{x:150,y:0.0035520000383257866},{x:200,y:0.002368000103160739}],key: "Bubble Sort",color: colors[0]},
	//			{values: [{x:50,y:0.0027630000840872526},{x:100,y:0.0011840000515803695},{x:150,y:0.0015790000325068831},{x:200,y:0.001973999897018075}],key: "Selection Sort",color: colors[1]}];
	
	var data = [{values:[{x:10,y:2.7420051097869873},{x:100,y:5.672854900360107},{x:500,y:9.83698558807373},{x:1000,y:17.659494400024414},{x:2000,y:105.45536804199219},{x:4000,y:86.38070678710938},{x:6000,y:176.498779296875},{x:10000,y:458.9593811035156},{x:15000,y:1035.260498046875},{x:20000,y:1851.748046875}],key:"BubbleSort",color:colors[0]},{values:[{x:10,y:0.3231799900531769},{x:100,y:0.8038769960403442},{x:500,y:2.9748589992523193},{x:1000,y:4.534998893737793},{x:2000,y:13.188518524169922},{x:4000,y:37.390602111816406},{x:6000,y:82.66818237304688},{x:10000,y:230.64791870117188},{x:15000,y:517.8759765625},{x:20000,y:917.2965087890625}],key:"SelectionSort",color:colors[1]},{values:[{x:10,y:0.40688198804855347},{x:100,y:0.5506079792976379},{x:500,y:7.586874961853027},{x:1000,y:9.306120872497559},{x:2000,y:19.861364364624023},{x:4000,y:53.94462966918945},{x:6000,y:127.23536682128906},{x:10000,y:343.50177001953125},{x:15000,y:758.4768676757812},{x:20000,y:1351.005859375}],key:"InsertionSort",color:colors[2]},{values:[{x:10,y:0.3197070062160492},{x:100,y:0.5812010169029236},{x:500,y:6.056502819061279},{x:1000,y:17.66031837463379},{x:2000,y:16.970096588134766},{x:4000,y:56.28013610839844},{x:6000,y:129.44236755371094},{x:10000,y:357.9725646972656},{x:15000,y:791.6668701171875},{x:20000,y:1402.587646484375}],key:"SimultaneousBubblesort",color:colors[3]}];;
	
	nv.addGraph(function() {
        chart = nv.models.lineChart()
            .options({
                transitionDuration: 50
            })
			.useInteractiveGuideline(true)
        ;
		chart.interpolate('basis');
		chart.useInteractiveGuideline(true)
		
        chart.xAxis
            .axisLabel("Input size")
            .tickFormat(d3.format(',.0f'))
            //.staggerLabels(true)
        ;

        chart.yAxis
            .axisLabel('Time (ms)')
            .tickFormat(function(d) {
                if (d == null) {
                    return 'N/A';
                }
                return d3.format(',.0f')(d);
            })
        ;

        d3.select('#chart1').append('svg')
            .datum(data)
            .call(chart);

        nv.utils.windowResize(chart.update);

        return chart;
    });

	
    /* function sinAndCos() {
        var sin = [],
            sin2 = [],
            cos = [],
            rand = [],
            rand2 = []
            ;

        for (var i = 0; i < 100; i++) {
            sin.push({x: i, y: i % 10 == 5 ? null : Math.sin(i/10) }); //the nulls are to show how defined works
            sin2.push({x: i, y: Math.sin(i/5) * 0.4 - 0.25});
            cos.push({x: i, y: .5 * Math.cos(i/10)});
            rand.push({x:i, y: Math.random() / 10});
            rand2.push({x: i, y: Math.cos(i/10) + Math.random() / 10 })
        }

		var alg1 = []
		alg1.push({x:0,y:0})
		alg1.push({x:50,y:0.026843000203371048})
		alg1.push({x:100,y:0.002764000091701746})
		alg1.push({x:150,y:0.0035520000383257866})
		alg1.push({x:150,y:0.002368000103160739})
		
		//[{"xaxis":200,"yaxis":,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":0,"yaxis":0.0,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":50,"yaxis":0.006711000110954046,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":100,"yaxis":0.002368000103160739,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":150,"yaxis":0.0015790000325068831,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":200,"yaxis":0.0015790000325068831,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":0,"yaxis":0.0,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":50,"yaxis":0.0027630000840872526,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":100,"yaxis":0.0011840000515803695,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":150,"yaxis":0.0015790000325068831,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":200,"yaxis":0.001973999897018075,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":0,"yaxis":0.0,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":50,"yaxis":0.008685000240802765,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":100,"yaxis":0.00355300004594028,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":150,"yaxis":0.002764000091701746,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":200,"yaxis":0.3687039911746979,"algorithmCode":0,"algorithm":"BubbleSort"},{"xaxis":0,"yaxis":0.0,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":50,"yaxis":0.01618500053882599,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":100,"yaxis":0.001973999897018075,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":150,"yaxis":0.0015790000325068831,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":200,"yaxis":0.0015780000248923898,"algorithmCode":1,"algorithm":"SelectionSort"},{"xaxis":0,"yaxis":0.0,"algorithmCode":2,"algorithm":"InsertionSort"},{"xaxis":50,"yaxis":0.0027630000840872526,"algorithmCode":2,"algorithm":"InsertionSort"},{"xaxis":100,"yaxis":0.0015790000325068831,"algorithmCode":2,"algorithm":"InsertionSort"},{"xaxis":150,"yaxis":0.0011840000515803695,"algorithmCode":2,"algorithm":"InsertionSort"},{"xaxis":200,"yaxis":0.0015790000325068831,"algorithmCode":2,"algorithm":"InsertionSort"}]
        return [
            //{
            //    area: true,
            //    values: sin,
            //    key: "Sine Wave",
            //    color: "#ff7f0e",
            //    strokeWidth: 4,
            //    classed: 'dashed'
            //},
            //{
            //    values: cos,
            //    key: "Cosine Wave",
            //    color: "#2ca02c"
            //},
			{
                values: alg1,
                key: "Bubble Sort",
                //color: "#2ca02c"
				color: colors[0]
            },
            //{
            //    values: rand,
            //    key: "Random Points",
            //    color: "#2222ff"
            //},
            //{
            //    values: rand2,
            //    key: "Random Cosine",
            //    color: "#667711",
            //    strokeWidth: 3.5
            //},
            //{
            //    area: true,
            //    values: sin2,
            //    key: "Fill opacity",
            //    color: "#EF9CFB",
            //    fillOpacity: .1
            //}
        ];
    } */
