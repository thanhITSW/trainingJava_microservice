package com.auth_service.controller;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import com.auth_service.dto.request.Account.ApiResponse;
import com.auth_service.entity.SystemConfig;
import com.auth_service.service.SystemConfigService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/system-config")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SystemConfigController {
    SystemConfigService systemConfigService;

    @GetMapping
    public ApiResponse<SystemConfig> getCurrentConfig() {
        SystemConfig config = systemConfigService.getConfig();

        return ApiResponse.<SystemConfig>builder()
                .result(config)
                .build();
    }

    @PostMapping("/maintenance")
    public ApiResponse<SystemConfig> updateMaintenanceMode(@RequestParam boolean maintenanceMode) {
        System.out.println(maintenanceMode);
        SystemConfig updatedConfig = systemConfigService.updateMaintenanceMode(maintenanceMode);

        return ApiResponse.<SystemConfig>builder()
                .result(updatedConfig)
                .build();
    }
}
