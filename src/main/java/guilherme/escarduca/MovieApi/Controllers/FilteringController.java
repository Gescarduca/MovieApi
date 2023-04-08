package guilherme.escarduca.MovieApi.Controllers;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import guilherme.escarduca.MovieApi.Models.SomeBean;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FilteringController {


    @GetMapping("/filtering")
    public MappingJacksonValue filtering(){
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);//we create an object of type MappingJacksonValue
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1","value3");//we create the filter we wish to enforce on the outgoing serialization
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter); //we create the instance that will 
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;

    }


    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList(){
         List<SomeBean> beans = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(beans);//we create an object of type MappingJacksonValue
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1","value3");//we create the filter we wish to enforce on the outgoing serialization
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter); //we create the instance that will
        mappingJacksonValue.setFilters(filterProvider);
        return mappingJacksonValue;
    }
}
