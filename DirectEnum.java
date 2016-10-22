import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yanqing on 2016/10/11.
 */
public enum DirectEnum {
    horizontal_0_0(1 , "0,0;0,1;0,2"),
    horizontal_0_1(2 , "0,1;0,2;0,3"),
    horizontal_1_0(3 , "1,0;1,1;1,2"),
    horizontal_1_1(4 , "1,1;1,2;1,3"),
    horizontal_2_0(5 , "2,0;2,1;2,2"),
    horizontal_2_1(6 , "2,1;2,2;2,3"),
    horizontal_3_0(7 , "3,0;3,1;3,2"),
    horizontal_3_1(8 , "3,1;3,2;3,3"),
    vertical_0_0(9,  "0,0;1,0;2,0"),
    vertical_1_0(10, "1,0;2,0;3,0"),
    vertical_0_1(11, "0,1;1,1;2,1"),
    vertical_1_1(12, "1,1;2,1;3,1"),
    vertical_0_2(13, "0,2;1,2;2,2"),
    vertical_1_2(14, "1,2;2,2;3,2"),
    vertical_0_3(15, "0,3;1,3;2,3"),
    vertical_1_3(16, "1,3;2,3;3,3"),
    up45_1_1(17, "0,2;1,1;2,0"),
    up45_2_1(18, "1,2;2,1;3,0"),
    up45_1_2(19, "2,1;1,2;0,3"),
    up45_2_2(20, "3,1;2,2;1,3"),
    down135_1_1(21, "0,0;1,1;2,2"),
    down135_2_1(22, "3,2;2,1;1,0"),
    down135_1_2(23, "2,3;1,2;0,1"),
    down135_2_2(24, "3,3;2,2;1,1");

    private int index;
    private String coordinate;

    private String msg;

    // 枚举对象构造函数
    private DirectEnum(int index, String coordinate) {
        this.coordinate = coordinate;
        this.index = index;
    }

    public List<String> getCoordinate() {
        List<String> coordinateList = new ArrayList<String>();
        String[] coordinateSplit = coordinate.split(";");
        for(String coordinates : coordinateSplit){
            coordinateList.add(coordinates);
        }
        return coordinateList;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static void main(String[] args) {
        for (DirectEnum rate: DirectEnum.values()) {
            List<String> list  = rate.getCoordinate();
            for(String str :list)
                System.out.print(str);
            System.out.println();
        }
    }
}
