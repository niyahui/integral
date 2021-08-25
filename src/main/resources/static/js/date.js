/**
 *
 var myDate = new Date();
 myDate.getYear(); //获取当前年份(2位)
 myDate.getFullYear(); //获取完整的年份(4位,1970-????)
 myDate.getMonth(); //获取当前月份(0-11,0代表1月)         // 所以获取当前月份是myDate.getMonth()+1;
 myDate.getDate(); //获取当前日(1-31)
 myDate.getDay(); //获取当前星期X(0-6,0代表星期天)
 myDate.getTime(); //获取当前时间(从1970.1.1开始的毫秒数)
 myDate.getHours(); //获取当前小时数(0-23)
 myDate.getMinutes(); //获取当前分钟数(0-59)
 myDate.getSeconds(); //获取当前秒数(0-59)
 myDate.getMilliseconds(); //获取当前毫秒数(0-999)
 myDate.toLocaleDateString(); //获取当前日期
 var mytime=myDate.toLocaleTimeString(); //获取当前时间
 myDate.toLocaleString( ); //获取日期与时间

 */

/**
 * 时间字符串转换时间戳
 * @param strDate
 */
function strToNum(strDate) {
    var mydate = new Date(strDate);
    return mydate.getTime() / 1000;
}

/**
 * 时间字符串转换为小时(去一制时间，不满一小时，不按一小时计算)
 * @param strDate
 * @returns
 */
function strToHoursMin(strDate) {
    var mydate = new Date(strDate);
    return mydate.getHours();
}

/**
 * 时间字符串转换为小时(进一制时间，不满一小时，按一小时计算)
 * @param strDate
 * @returns
 */
function strToHoursMax(strDate) {
    var mydate = new Date(strDate);
    var sen = mydate.getSeconds();
    if (sen > 0) {
        return mydate.getHours() + 1;
    }
    return mydate.getHours();
}

/**
 * 时间戳转时间格式
 * @param time
 * @param format
 * @returns
 */
function dateNumToDate(time) {
    var date = dateTo('Y-m-d H:i:s', time);
    return date;
}

/**
 * 天数时间差
 * datestr1,datestr2 时间按字符串，1小2大
 */
function chaDay(datestr1, datestr2) {
    var date1 = new Date(datestr1);
    var date2 = new Date(datestr2);
    var s1 = date1.getTime(), s2 = date2.getTime();
    var total = (s2 - s1) / 1000;
    var day = parseInt(total / (24 * 60 * 60));//计算整数天数
    var afterDay = total - day * 24 * 60 * 60;//取得算出天数后剩余的秒数
    return day;
}

/**
 * 小时时间差
 * datestr1,datestr2 时间按字符串，1小2大
 * 0为去时间，1为进一时间
 */
function hoursCha(datestr1, datestr2, state) {
    var date1 = new Date(datestr1);
    var date2 = new Date(datestr2);
    console.log(date1);
    console.log(date2);
    var s1 = date1.getTime(), s2 = date2.getTime();
    console.log(s1);
    console.log(s2);
    var total = (s2 - s1) / 1000;
    var day = parseInt(total / (24 * 60 * 60));//计算整数天数
    var afterDay = total - day * 24 * 60 * 60;//取得算出天数后剩余的秒数
    var hour = parseInt(afterDay / (60 * 60));//计算整数小时数
    var afterHour = total - day * 24 * 60 * 60 - hour * 60 * 60;//取得算出小时数后剩余的秒数
    var min = parseInt(afterHour / 60);//计算整数分
    var afterMin = total - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60;//取得算出分后剩余的秒数
    if (state == 0) {
        return hour + (day * 24);
    } else {
        if (afterHour > 0) {
            return hour + (day * 24) + 1;
        } else {
            return hour + (day * 24);
        }
    }
}


function timeDifference(datestr1, datestr2) {
    var date1 = new Date(datestr1);
    var date2 = new Date(datestr2);
    console.log(date1);
    console.log(date2);
    var s1 = date1.getTime(), s2 = date2.getTime();
    console.log(s1);
    console.log(s2);
    var total = (s2 - s1) / 1000;
    var day = parseInt(total / (24 * 60 * 60));//计算整数天数
    var afterDay = total - day * 24 * 60 * 60;//取得算出天数后剩余的秒数
    var hour = parseInt(afterDay / (60 * 60));//计算整数小时数
    var afterHour = total - day * 24 * 60 * 60 - hour * 60 * 60;//取得算出小时数后剩余的秒数
    var min = parseInt(afterHour / 60);//计算整数分
    var afterMin = total - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60;//取得算出分后剩余的秒数
    console.log("相减得到的结果：计算整数天数-" + day);
    console.log("相减得到的结果：取得算出天数后剩余的秒数-" + afterDay);
    console.log("相减得到的结果：计算整数小时数-" + hour);
    console.log("相减得到的结果：取得算出小时数后剩余的秒数-" + afterHour);
    console.log("相减得到的结果：计算整数分-" + min);
    console.log("相减得到的结果：取得算出分后剩余的秒数-" + afterMin);
}


/**
 * 时间戳格式化函数
 * @param {string} format 格式
 * @param {int} timestamp 要格式化的时间 默认为当前时间
 * @return {string}   格式化的时间字符串
 */
function dateTo(format, timestamp) {
    var a, jsdate = ((timestamp) ? new Date(timestamp * 1000) : new Date());
    var pad = function (n, c) {
        if ((n = n + "").length < c) {
            return new Array(++c - n.length).join("0") + n;
        } else {
            return n;
        }
    };
    var txt_weekdays = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    var txt_ordin = {1: "st", 2: "nd", 3: "rd", 21: "st", 22: "nd", 23: "rd", 31: "st"};
    var txt_months = ["", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    var f = {
        // Day 
        d: function () {
            return pad(f.j(), 2)
        },
        D: function () {
            return f.l().substr(0, 3)
        },
        j: function () {
            return jsdate.getDate()
        },
        l: function () {
            return txt_weekdays[f.w()]
        },
        N: function () {
            return f.w() + 1
        },
        S: function () {
            return txt_ordin[f.j()] ? txt_ordin[f.j()] : 'th'
        },
        w: function () {
            return jsdate.getDay()
        },
        z: function () {
            return (jsdate - new Date(jsdate.getFullYear() + "/1/1")) / 864e5 >> 0
        },

        // Week 
        W: function () {
            var a = f.z(), b = 364 + f.L() - a;
            var nd2, nd = (new Date(jsdate.getFullYear() + "/1/1").getDay() || 7) - 1;
            if (b <= 2 && ((jsdate.getDay() || 7) - 1) <= 2 - b) {
                return 1;
            } else {
                if (a <= 2 && nd >= 4 && a >= (6 - nd)) {
                    nd2 = new Date(jsdate.getFullYear() - 1 + "/12/31");
                    return date("W", Math.round(nd2.getTime() / 1000));
                } else {
                    return (1 + (nd <= 3 ? ((a + nd) / 7) : (a - (7 - nd)) / 7) >> 0);
                }
            }
        },

        // Month 
        F: function () {
            return txt_months[f.n()]
        },
        m: function () {
            return pad(f.n(), 2)
        },
        M: function () {
            return f.F().substr(0, 3)
        },
        n: function () {
            return jsdate.getMonth() + 1
        },
        t: function () {
            var n;
            if ((n = jsdate.getMonth() + 1) == 2) {
                return 28 + f.L();
            } else {
                if (n & 1 && n < 8 || !(n & 1) && n > 7) {
                    return 31;
                } else {
                    return 30;
                }
            }
        },

        // Year 
        L: function () {
            var y = f.Y();
            return (!(y & 3) && (y % 1e2 || !(y % 4e2))) ? 1 : 0
        },
        //o not supported yet 
        Y: function () {
            return jsdate.getFullYear()
        },
        y: function () {
            return (jsdate.getFullYear() + "").slice(2)
        },

        // Time 
        a: function () {
            return jsdate.getHours() > 11 ? "pm" : "am"
        },
        A: function () {
            return f.a().toUpperCase()
        },
        B: function () {
            // peter paul koch: 
            var off = (jsdate.getTimezoneOffset() + 60) * 60;
            var theSeconds = (jsdate.getHours() * 3600) + (jsdate.getMinutes() * 60) + jsdate.getSeconds() + off;
            var beat = Math.floor(theSeconds / 86.4);
            if (beat > 1000) beat -= 1000;
            if (beat < 0) beat += 1000;
            if ((String(beat)).length == 1) beat = "00" + beat;
            if ((String(beat)).length == 2) beat = "0" + beat;
            return beat;
        },
        g: function () {
            return jsdate.getHours() % 12 || 12
        },
        G: function () {
            return jsdate.getHours()
        },
        h: function () {
            return pad(f.g(), 2)
        },
        H: function () {
            return pad(jsdate.getHours(), 2)
        },
        i: function () {
            return pad(jsdate.getMinutes(), 2)
        },
        s: function () {
            return pad(jsdate.getSeconds(), 2)
        },
        //u not supported yet 

        // Timezone 
        //e not supported yet 
        //I not supported yet 
        O: function () {
            var t = pad(Math.abs(jsdate.getTimezoneOffset() / 60 * 100), 4);
            if (jsdate.getTimezoneOffset() > 0) t = "-" + t; else t = "+" + t;
            return t;
        },
        P: function () {
            var O = f.O();
            return (O.substr(0, 3) + ":" + O.substr(3, 2))
        },
        //T not supported yet 
        //Z not supported yet 

        // Full Date/Time 
        c: function () {
            return f.Y() + "-" + f.m() + "-" + f.d() + "T" + f.h() + ":" + f.i() + ":" + f.s() + f.P()
        },
        //r not supported yet 
        U: function () {
            return Math.round(jsdate.getTime() / 1000)
        }
    };

    return format.replace(/[\\]?([a-zA-Z])/g, function (t, s) {
        if (t != s) {
            // escaped 
            ret = s;
        } else if (f[s]) {
            // a date function exists 
            ret = f[s]();
        } else {
            // nothing special 
            ret = s;
        }
        return ret;
    });
}
