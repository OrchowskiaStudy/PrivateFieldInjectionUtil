package com.orchowskia.study.utils.injection;

import org.junit.Test;

import static com.orchowskia.study.utils.injection.Util.injectPrivateDependency;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class UserContextTest {
    @Test
    public void all_fields_should_be_null() {
        //arrange
        UserContext toFill = new UserContext();

        //act
        // :(

        //assert
        assertThat(toFill.getId()).isNull();
        assertThat(toFill.getName()).isNull();
    }

    @Test
    public void should_inject_id() {
        //arrange
        String id = "1234-4321";
        UserContext toFill = new UserContext();
        Id toInject = new Id(id);

        //act
        injectPrivateDependency(toFill, toInject);

        //assert
        assertThat(toFill.getId()).isNotNull();
        assertThat(toFill.getId().toString()).isEqualTo(id);
        assertThat(toFill.getId()).isEqualTo(toInject);
        assertThat(toFill.getName()).isNull();
    }


    @Test
    public void should_inject_name() {
        //arrange
        String name = "orchowskaj";
        UserContext toFill = new UserContext();
        Name toInject = new Name(name);

        //act
        injectPrivateDependency(toFill, toInject);

        //assert
        assertThat(toFill.getId()).isNull();
        assertThat(toFill.getName()).isNotNull();
        assertThat(toFill.getName().toString()).isEqualTo(name);
        assertThat(toFill.getName()).isEqualTo(toInject);
    }

    @Test
    public void should_inject_both() {
        //arrange
        String name = "orchowskaj";
        String id = "1234-4321";
        UserContext toFill = new UserContext();
        Id idToInject = new Id(id);
        Name nameToInject = new Name(name);


        //act
        injectPrivateDependency(toFill, idToInject);
        injectPrivateDependency(toFill, nameToInject);

        //assert
        assertThat(toFill.getId()).isNotNull();
        assertThat(toFill.getId().toString()).isEqualTo(id);
        assertThat(toFill.getId()).isEqualTo(idToInject);
        assertThat(toFill.getName()).isNotNull();
        assertThat(toFill.getName().toString()).isEqualTo(name);
        assertThat(toFill.getName()).isEqualTo(nameToInject);
    }

}