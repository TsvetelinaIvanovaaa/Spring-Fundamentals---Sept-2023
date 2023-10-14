package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.dto.AddRouteBindingModel;
import bg.softuni.pathfinder.model.entity.Category;
import bg.softuni.pathfinder.model.entity.Route;
import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.repository.CategoryRepository;
import bg.softuni.pathfinder.repository.RouteRepository;
import bg.softuni.pathfinder.service.RouteService;
import bg.softuni.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public RouteServiceImpl(RouteRepository routeRepository, CategoryRepository categoryRepository, ModelMapper modelMapper, UserService userService) {
        this.routeRepository = routeRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    public void add(AddRouteBindingModel addRouteBindingModel) {

        Route route = modelMapper.map(addRouteBindingModel, Route.class);
        route.getCategories().clear();

        Set<Category> categories = categoryRepository.findByNameIn(addRouteBindingModel.getCategories());
        route.addCategories(categories);

        User user = userService.getLoggedUser();
        route.setAuthor(user);

        routeRepository.save(route);
    }
}
