function sendAJAX()
{
    //弄个加载页面
    document.getElementById("loader").className="ui active dimmer";
    var sc1 = document.getElementById("_01");
    var sc2 = document.getElementById("_02");
    var sc3 = document.getElementById("_03");
    var root = this;

    if(sc1.value !== "" && sc2.value !== "" && sc3.value !== "")
    {
        var data = JSON.stringify(sc1.value + " " +sc2.value + " " + sc3.value);
        $.ajax(
            {
                url: "/faculty/calculateGrade",
                data: jQuery.parseJSON(data),
                type: "POST",
                dataType: "json",
                success:
                // setTimeout(function()
                // {
                //     //显示出总成绩
                //     document.getElementById("_04").value = this.data;
                //     document.getElementById("loader").className="none";
                //
                // }, 2000)
                    function(data)
                {
                    //显示出总成绩
                    document.getElementById("_04").value = data;
                    document.getElementById("loader").className="none";

                }
            }
        )

    }
    //将按钮替换
    document.getElementById("button1").style.display = "none";
    document.getElementById("button2").style.display = "block";
}

function modal()
{
    var sc1 = document.getElementById("_01");
    var sc2 = document.getElementById("_02");
    var sc3 = document.getElementById("_03");
    var sc4 = document.getElementById("_04");
    var sc5 = document.getElementById("_05");
    var sc6 = document.getElementById("_06");
    var sc7 = document.getElementById("_07");
    var sc8 = document.getElementById("_08");
    sc5.innerText = sc1.value;
    sc6.innerText = sc2.value;
    sc7.innerText = sc3.value;
    sc8.innerText = sc4.value;

    $('.ui.tiny.modal').modal('show');
}
