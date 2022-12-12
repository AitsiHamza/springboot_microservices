package org.sid.billing;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//@RefreshScope
@AllArgsConstructor
public class VaultConfigRestController {
    /*
    @Value("${token.accessTokenTimeout}")
    private long accessTokenTimeout;
    @Value("${token.refreshTokenTimeout}")
    private long refreshTokenTimeout;
    */
    private MyConsulConfig myConsulConfig;

    private MyVaultConfig myVaultConfig;

    @GetMapping("/myConfig")
    public Map<String,Object> myConfig() {
        return Map.of("consulConfig",myConsulConfig,"vaultConfig",myVaultConfig);
    }

    @GetMapping("/myVaultConfig")
    public MyVaultConfig myVaultConfig() {
        return myVaultConfig;
    }

    @GetMapping("/myConsulConfig")
    public MyConsulConfig myConsulConfig() {
        return myConsulConfig;
    }
}
