package duplenskikh.homework.custom_array_list;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CustomArrayListTest {

    @Test
    void sizeShouldBeEqualAddedElementsCount() {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        customArrayList.add("message");
        assertThat(customArrayList.size()).isEqualTo(1);
    }

    @Test
    void emptyCustomArrayListSizeShouldBeZero() {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        assertThat(customArrayList.size()).isEqualTo(0);
    }

    @Test
    void emptyCustomArrayListShouldBeEmpty() {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        assertThat(customArrayList.isEmpty()).isEqualTo(true);
    }

    @Test
    void filledCustomArrayListShouldNotBeEmpty() {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        customArrayList.add("message");
        assertThat(customArrayList.isEmpty()).isEqualTo(false);
    }

    @Test
    void customArrayListShouldContainSpecifiedElement() {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        String string = "message";
        customArrayList.add(string);
        assertThat(customArrayList.contains(string)).isEqualTo(true);
        assertThat(customArrayList.get(0)).isEqualTo(string);
    }

    @Test
    void customArrayListShouldNotContainInexistentElement() {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        String string1 = "message";
        String string2 = "another";
        customArrayList.add(string1);
        assertThat(customArrayList.contains(string2)).isEqualTo(false);
    }

    @Test
    void addedByIndexElementShouldHaveSpecifiedIndex() {
        CustomArrayList<String> customArrayList = new CustomArrayList<>(new String[]{"first", "third"});
        String string = "second";
        customArrayList.add(1, string);
        assertThat(customArrayList.indexOf(string)).isEqualTo(1);
    }

    @Test
    void addingByWrongIndexShouldThrowIndexOutOfBoundsException() {
        CustomArrayList<String> customArrayList = new CustomArrayList<>(new String[]{"first"});
        String string = "third";
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            customArrayList.add(2, string);
        });
    }

    @Test
    void customArrayListShouldNotContainRemovedElement() {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        String string = "message";
        customArrayList.add(string);
        customArrayList.remove(string);
        assertThat(customArrayList.contains(string)).isEqualTo(false);
        assertThat(customArrayList.size()).isEqualTo(0);
    }

    @Test
    void customArrayListShouldNotContainRemovedByIndexElement() {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        String string1 = "first";
        String string2 = "second";
        customArrayList.add(string1);
        customArrayList.add(string2);
        customArrayList.remove(0);
        assertThat(customArrayList.contains(string1)).isEqualTo(false);
        assertThat(customArrayList.get(0)).isEqualTo(string2);
    }

    @Test
    void removingByWrongIndexShouldThrowIndexOutOfBoundsException() {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        String string = "message";
        customArrayList.add(string);
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            customArrayList.remove(1);
        });
    }

    @Test
    void subList() {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        CustomArrayList<String> subList;
        String string1 = "first";
        String string2 = "second";
        String string3 = "third";
        String string4 = "fourth";
        customArrayList.add(string1);
        customArrayList.add(string2);
        customArrayList.add(string3);
        customArrayList.add(string4);
        subList = customArrayList.subList(1, 3);
        assertThat(subList.size()).isEqualTo(2);
        assertThat(subList.get(0)).isEqualTo(string2);
        assertThat(subList.indexOf(string3)).isEqualTo(1);
    }
}