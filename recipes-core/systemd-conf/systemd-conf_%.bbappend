FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://10-wlan0.network \
"

RDEPENDS:${PN}:append = " wpa-supplicant "

FILES:${PN} += " \
    ${sysconfdir}/systemd/network/10-wlan0.network \
"

do_install:append() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/10-wlan0.network ${D}${sysconfdir}/systemd/network
}