package airbnb;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by jun on 4/13/16.
 * <p>
 * Implement per-page display. Given the inputs below, which are already sorted by score, display 12 per page.
 * If some item shares same id with previous one on this page, then display it on the next page.
 */
public class PageDisplay {
    public static void main(String[] args) {
        String[] input = new String[]{
                "1,28,300.1,SanFrancisco",
                "4,5,209.1,SanFrancisco",
                "20,7,208.1,SanFrancisco",
                "23,8,207.1,SanFrancisco",
                "16,10,206.1,Oakland",
                "1,16,205.1,SanFrancisco",
                "6,29,204.1,SanFrancisco",
                "7,20,203.1,SanFrancisco",
                "8,21,202.1,SanFrancisco",
                "2,18,201.1,SanFrancisco",
                "2,30,200.1,SanFrancisco",
                "15,27,109.1,Oakland",
                "10,13,108.1,Oakland",
                "11,26,107.1,Oakland",
                "12,9,106.1,Oakland",
                "13,1,105.1,Oakland",
                "22,17,104.1,Oakland",
                "1,2,103.1,Oakland",
                "28,24,102.1,Oakland",
                "18,14,11.1,SanJose",
                "6,25,10.1,Oakland",
                "19,15,9.1,SanJose",
                "3,19,8.1,SanJose",
                "3,11,7.1,Oakland",
                "27,12,6.1,Oakland",
                "1,3,5.1,Oakland",
                "25,4,4.1,SanJose",
                "5,6,3.1,SanJose",
                "29,22,2.1,SanJose",
                "30,23,1.1,SanJose"
        };

        PageDisplay p = new PageDisplay();
        p.display(input, 12);
    }

//    public void display(String[] inputs, int linesPerPage) {
//        Map<Integer, String> map = new LinkedHashMap<>();
//
//        List<String> lines = new LinkedList<>(Arrays.asList(inputs));
//        int counter = 0;
//        int page = 1;
//        Iterator<String> iterator;
//
//        while (!lines.isEmpty()) {
//            iterator = lines.iterator();
//
//            while (counter < linesPerPage && iterator.hasNext()) {
//                String line = iterator.next();
//                int host = hostId(line);
//                if (!map.containsKey(host)) {
//                    map.put(host, line);
//                    counter++;
//                    iterator.remove();
//                }
//            }
//
//            System.out.println("Page " + page++);
//            for (String line : map.values()) {
//                System.out.println(line);
//            }
//
//            map.clear();
//            counter=0;
//        }
//    }
//
//    public int hostId(String line) {
//        return Integer.valueOf(line.split(",")[0]);
//    }



    public void display(String[] input, int linesPerPage) {
        if (input.length == 0)
            return;

        List<String> list = new LinkedList<>();
        list.addAll(Arrays.asList(input));

        Iterator<String> iterator = list.iterator();

        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        int pageNum = 1;

        while (iterator.hasNext()) {
            String line = iterator.next();
            int hostId = hostId(line);
            if (!map.containsKey(hostId)) {
                map.put(hostId, line);
                iterator.remove();
            }

            if (map.size() >= linesPerPage || !iterator.hasNext()) { // it's a if loop, not while
                System.out.println("Page " + pageNum++);
                for (String l : map.values())
                    System.out.println(l);

                map.clear(); // ** remember to clear map and reset iterator
                iterator = list.iterator();
            }
        }
    }

    public int hostId(String line) {
        return Integer.valueOf(line.split(",")[0]);
    }

//    public void display(String[] lines, int linesPerPage) {
//        List<Collection<String>> pages = new LinkedList<>();
//        LinkedHashMap<Integer, String> page = new LinkedHashMap<>();
//        LinkedList<String> buffer = new LinkedList<>(); // holds lines which cannot fit into current page
//
//        int i = 0;
//        while (!buffer.isEmpty() || i < lines.length) {
//            Iterator<String> bufferItr = buffer.iterator(); // be sure to use iterator here to avoid concurrent modification and fast delete
//            while (bufferItr.hasNext()) {
//                String line = bufferItr.next();
//                int hostId = hostId(line);
//                if (!page.containsKey(hostId)) {
//                    page.put(hostId, line);
//                    bufferItr.remove();
//                }
//
//                if (page.size() == linesPerPage)
//                    break;
//            }
//
//            if (i < lines.length) {
//                String line = lines[i];
//                int hostId = hostId(line);
//                if (!page.containsKey(hostId) && page.size() < linesPerPage) {
//                    page.put(hostId, line);
//                } else {
//                    buffer.add(line);
//                }
//                i++; // can't leave this out side of the loop, or it will be incremented unintentionally, or else i can check for i >= lines.length to print out stuff
//            }
//
//            if (page.size() == linesPerPage || i == lines.length) {
//                // add a new page onto pages
//                pages.add(page.values());
//                page = new LinkedHashMap<>();
//            }
//        }
//
//        for (int j = 0; j < pages.size(); j++) {
//            System.out.println("Page " + (j + 1));
//            for (String line : pages.get(j))
//                System.out.println(line);
//        }
//    }
//
//
//    public int hostId(String line) {
//        return Integer.valueOf(line.split(",")[0]);
//    }
}
