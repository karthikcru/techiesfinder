import twitter4j.Twitter;
import twitter4j.IDs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class GetUserStatus {

    public static void main(String[] args) throws IOException{

        File file =new File("userids.txt");
        FileWriter fileWriter = new FileWriter(file.getName(),true);
        BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
        Twitter twitter = GetTwitterConnection.getConnection("8uuuFqbBuFWFmeLoXtjtunxPK","Q6sP8qtSPZRl7ye6nWDcSI37kaC3RLvkG9PTew37D0OIPGV9Df",
                                                             "389445114-BsFr5U9rJMOscDGQ15odzOhE3NwxPGAs4LOKhnPA","6hWvHG2hJ34hUFixzhyEabNYiKZBO4GCIWPkDsiDo5ADc");


        try {
            long cursor = -1;
            IDs ids;
            System.out.println("Listing followers's ids.");
            System.out.println("getting the followers of "+ args[0]);
            do {
                if (0 < args.length) {
                    ids = twitter.getFollowersIDs(args[0], cursor);
                } else {
                    ids = twitter.getFollowersIDs(cursor);
                }

                System.out.print(ids.getIDs().length );
                long[] IDDS = ids.getIDs();
                System.out.println(Arrays.toString(IDDS));
                bufferWriter.write(Arrays.toString(IDDS).replaceAll("\\[(.*?)\\]", "$1"));
                bufferWriter.close();


            } while ((cursor = ids.getNextCursor()) != 0);
            System.exit(0);
        } catch (Exception te) {
            te.printStackTrace();
            System.out.println("Failed to get followers' ids: " + te.getMessage());
            System.exit(-1);
        }

    }
}
	
	
	
	