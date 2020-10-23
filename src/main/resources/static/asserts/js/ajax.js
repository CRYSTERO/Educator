function sendAJAX()
{
    var sc1 = document.getElementById("_01");
    var sc2 = document.getElementById("_02");
    var sc3 = document.getElementById("_03");
    if(sc1.value !== "" && sc2.value !== "" && sc3.value !== "")
    {
        var data = JSON.stringify(sc1.value + " " +sc2.value + " " + sc3.value);
        $.ajax(
            {
                url: "/faculty/calculateGrade",
                data: jQuery.parseJSON(data),
                type: "POST",
                dataType: "json",
                success: function(data)
                {
                    //显示出总成绩
                    document.getElementById("_04").value = data;

                }
            }
        )

    }
}