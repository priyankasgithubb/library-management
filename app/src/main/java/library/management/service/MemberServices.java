package library.management.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import library.management.entities.Book;
import library.management.entities.Member;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class MemberServices {

    private List<Book> bookList;
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final String MEMBER_DB_PATH = "src/main/java/library/management/localDB/members.json";
    private List<Member> memberList;

    public MemberServices() throws IOException {

        File members = new File(MEMBER_DB_PATH);

        memberList = objectMapper.readValue(
                members,
                new TypeReference<List<Member>>() {
                }
        );
    }

    public List<Member> searchMember(String name){

        return memberList.stream()
                .filter(member ->
                        member.getMemberName()
                                .toLowerCase()
                                .contains(name.toLowerCase()))
                .toList();
    }

    public void addMember(Member newMember) {

        Optional<Member> existingMember =
                memberList.stream()
                        .filter(member ->
                                member.getMemberId()
                                        .equalsIgnoreCase(newMember.getMemberId()))
                        .findFirst();

        if(existingMember.isPresent()) {
            updateMember(newMember);
        }
        else {
            memberList.add(newMember);
            saveMemberListToFile();
        }
    }

    public void updateMember(Member updatedMember) {

        OptionalInt index =
                IntStream.range(0, memberList.size())
                        .filter(i ->
                                memberList.get(i)
                                        .getMemberId()
                                        .equalsIgnoreCase(updatedMember.getMemberId()))
                        .findFirst();

        if(index.isPresent()) {

            memberList.set(
                    index.getAsInt(),
                    updatedMember
            );

            saveMemberListToFile();
        }
        else {

            addMember(updatedMember);
        }
    }

    private void saveMemberListToFile() {

        try {

            objectMapper.writeValue(
                    new File(MEMBER_DB_PATH),
                    memberList
            );

        } catch(IOException e) {

            e.printStackTrace();
        }
    }

    public List<Member> getAllMembers() {
        return memberList;
    }
}

