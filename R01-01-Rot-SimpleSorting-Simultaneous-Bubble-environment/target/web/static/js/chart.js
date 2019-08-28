// Wrapping in nv.addGraph allows for '0 timeout render', stores rendered charts in nv.graphs, and may do more in the future... it's NOT required
    var chart;
    var colors = ["#ff7f0e","#2ca02c","#2222ff","#667711","#EF9CFB"];
	//var data = [{values: [{x:50,y:0.026843000203371048},{x:100,y:0.002764000091701746},{x:150,y:0.0035520000383257866},{x:200,y:0.002368000103160739}],key: "Bubble Sort",color: colors[0]},
	//			{values: [{x:50,y:0.0027630000840872526},{x:100,y:0.0011840000515803695},{x:150,y:0.0015790000325068831},{x:200,y:0.001973999897018075}],key: "Selection Sort",color: colors[1]}];
	
	var data = [{values:[{x:10,y:4.519622802734375},{x:100,y:7.891107082366943},{x:500,y:11.686113357543945},{x:1000,y:22.49277687072754},{x:2000,y:89.36112976074219},{x:4000,y:178.92066955566406},{x:6000,y:205.09283447265625},{x:10000,y:583.6171875},{x:15000,y:1505.8475341796875},{x:20000,y:2000.0}],key:"BubbleSort",color:colors[0]},{values:[{x:10,y:0.4134179949760437},{x:100,y:1.201213002204895},{x:500,y:7.948764801025391},{x:1000,y:10.934468269348145},{x:2000,y:12.884209632873535},{x:4000,y:22.539024353027344},{x:6000,y:58.43165588378906},{x:10000,y:125.3384780883789},{x:15000,y:286.1876525878906},{x:20000,y:344.9413146972656}],key:"SelectionSort",color:colors[1]},{values:[{x:10,y:0.5072190165519714},{x:100,y:3.7722110748291016},{x:500,y:9.633169174194336},{x:1000,y:14.044721603393555},{x:2000,y:22.50078010559082},{x:4000,y:61.51948928833008},{x:6000,y:148.08694458007812},{x:10000,y:387.4330139160156},{x:15000,y:856.1921997070312},{x:20000,y:1541.314208984375}],key:"InsertionSort",color:colors[2]},{values:[{x:10,y:0.43941399455070496},{x:100,y:0.832846999168396},{x:500,y:12.958019256591797},{x:1000,y:16.48359489440918},{x:2000,y:33.755794525146484},{x:4000,y:99.32923126220703},{x:6000,y:226.21487426757812},{x:10000,y:619.2529296875},{x:15000,y:1385.2440185546875},{x:20000,y:2000.0}],key:"SimultaneousBubblesort",color:colors[3]}];;
	
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
