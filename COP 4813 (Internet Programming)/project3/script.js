var valuesEntered;
var values = [];

function calcMean() {
    var sum = calcSum(values);
    length = getLength(values);
    var mean = sum / length;
    mean = toFloat(mean);
    return mean;
}

function calcMedian() {
    var median = 0;
    length = getLength(values);
    values.sort();
    if (
        length % 2 === 0
    ) {
        median = (values[length / 2 - 1] + values[length / 2]) / 2;
    } else {
        median = values[(length - 1) / 2];
    }
    median = toFloat(median);
    return median;
}

function calcMode() {
    var modes = [],
        count = [],
        i, number, maxIndex = 0;
        length = getLength(values);
    for (i = 0; i < length; i += 1) {
        number = values[i];
        count[number] = (count[number] || 0) + 1;
        if (count[number] > maxIndex) {
            maxIndex = count[number];
        }
    }
    for (i in count)
        if (count.hasOwnProperty(i)) {
            if (count[i] === maxIndex) {
                modes.push(Number(i));
            }
        }
    modes = modes.join(" ");
    return modes;
}

function calcStdDev() {
    variance = calcVariance();
    stddev = Math.sqrt(variance);
    stddev = toFloat(stddev);
    return stddev;
}

function calcSum() {
    var sum = 0;
    length = getLength(values);
    for (var i = 0; i < length; i++) {
        sum += values[i];
    }
    sum = toFloat(sum);
    return sum;
}

function calcVariance() {
    mean = calcMean();
    var len = 0;
    var sum = 0;
    length = getLength(values);
    for (var i = 0; i < length; i++) {
        len = len + 1;
        sum = sum + parseFloat(values[i]);
    }
    var v = 0;
    var mean = sum / len;
    for (var i = 0; i < length; i++) {
        if (values[i] == "") {} else {
            v = v + (values[i] - mean) * (values[i] - mean);
        }
    }
    var variance = v / len;
    variance = toFloat(variance);
    return variance;
}

function findMax() {
    valuesSorted = values.sort(sortValues);
    max = valuesSorted[length - 1];
    max = toFloat(max);
    return max;

}

function findMin() {
    valuesSorted = values.sort(sortValues);
    min = valuesSorted[0];
    min = toFloat(min);
    return min;
}

function toFloat(value){
     float = parseFloat(value).toFixed(2);
     return float;
}

function getLength(value){
    length = value.length;
    return length;
}

function sortValues(a, b){
    return a - b;
}

function performStatistics() {
    valuesEntered = document.forms["calculator"]["values"].value;
    values = valuesEntered.split(" ").map(Number);
    document.forms["calculator"]["sum"].value = calcSum();
    document.forms["calculator"]["mean"].value = calcMean();
    document.forms["calculator"]["median"].value = calcMedian();
    document.forms["calculator"]["mode"].value = calcMode();
    document.forms["calculator"]["max"].value = findMax();
    document.forms["calculator"]["min"].value = findMin();
    document.forms["calculator"]["variance"].value = calcVariance();
    document.forms["calculator"]["stddev"].value = calcStdDev();
}
