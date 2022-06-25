package ahn_simple.aop.simplelistview1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var data = arrayListOf<ListItem>(
        ListItem(R.drawable.health_icon_1, "health01", "2022/06/24"),
        ListItem(R.drawable.health_icon_2, "health02", "2022/06/25"),
        ListItem(R.drawable.united_kingdom, "UK", "2023/01/01")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lv = findViewById<ListView>(R.id.lv)

        val adapter = MyAdapter(this, data)
        lv.adapter = adapter
    }


    /*
    1. 데이터 클래스 정의
    2. 레이아웃에 ListView 추가
    3. item 생성
    4. 어댑터 생성!
    5. 어댑터 설정!
    */
}

class ListItem(val img: Int, val title: String, val content: String)
class MyAdapter(val context: Context, val dataList: ArrayList<ListItem>) : BaseAdapter() {

    //getCount ---> ListView에 속한 item의 전체 수 반환
    override fun getCount(): Int = dataList.size

    // getItem ---> 해당 위치의 item (ex: ListView 1번째 item 선택 및 반환 ---> getItem(0))
    override fun getItem(p0: Int): Any = dataList[p0]

    // getItemId ---> 해당 위치의 item의 id 반환
    override fun getItemId(p0: Int): Long = p0.toLong()

    // getView ---> xml 파일의 View와 데이터 연결!
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val v: View = LayoutInflater.from(context).inflate(R.layout.list_item, null)

        val itemImg = v.findViewById<ImageView>(R.id.item_img)
        val itemTitle = v.findViewById<TextView>(R.id.item_tv_title)
        val itemContent = v.findViewById<TextView>(R.id.item_tv_content)

        val content = dataList[p0]

        itemImg.setImageResource(content.img)
        itemTitle.text = content.title
        itemContent.text = content.content

        return v
    }

}
